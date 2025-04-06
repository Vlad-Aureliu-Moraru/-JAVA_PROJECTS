const main_container = document.querySelector(".main_container");
const complete_button = document.querySelector(".complete_task");
let task_completed = false;
/*
!todo: add a function to add a task to the list         []
!todo : add a function to remove a task from the list   []
!todo: add a function to mark a task as completed       []
!todo: add a function to mark a task as not completed   []
!todo: add a function to mark a task as important       []
!todo: add a function to update a task                  []
!todo: fetch tasks from the server                      []
!todo: log in the user                                  []
!todo: sing in the user                                 []

!clean the api 
!add api qol

*/
console.log("HELO")
const api = "http://localhost:8080/user/4"
async function fetchData(){
try{
  const response = await fetch(api);
  if (!response.ok){
    throw new Error('HTTP ERROR');
  }
  const data = await response.json();
  console.log(data);
  return data;
}catch (error){
  console.error("ERROR");
}
}

function completeTask() {
  fetchData();
}
function addTask() {}
