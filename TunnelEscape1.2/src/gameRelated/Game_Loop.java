package gameRelated;

public class Game_Loop implements Runnable{
    private static final int TARGET_FPS = 60; // Target frames per second
    private static final long OPTIMAL_TIME = 1_000_000_000 / TARGET_FPS; // Time per frame in nanoseconds

    private boolean running = false;
    private Thread gameThread;
    private Frame_Main frame;
    public Game_Loop() {
        frame = new Frame_Main();
    }
    public void start() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stop() {
        running = false;
        try {
            gameThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastUpdateTime = System.nanoTime();
        long accumulator = 0;

        while (running) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastUpdateTime;
            lastUpdateTime = currentTime;
            accumulator += elapsedTime;

            // Process input, update, and render at a fixed rate
            while (accumulator >= OPTIMAL_TIME) {
                processInput();
                update();
                accumulator -= OPTIMAL_TIME;
            }

            render();

            // Sleep to maintain consistent frame rate
            try {
                long sleepTime = (lastUpdateTime - System.nanoTime() + OPTIMAL_TIME) / 1_000_000;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processInput() {
        // Handle user input (e.g., keyboard, mouse)
    }

    private void update() {
        frame.update();
        if (frame.getPanel_game().getStopGame()){
            this.stop();
        }
    }

    private void render() {

    }
}
