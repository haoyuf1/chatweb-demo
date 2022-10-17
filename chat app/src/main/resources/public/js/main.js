/*should be using json/ localstorage/ cookies to store the data*/
let room_array = 0;
let current_room = null;
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function menuFunction() {
  document.getElementById("menudropdown").classList.toggle("show");
}


function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function roomSetting() {
  document.getElementById("roomDropdown").classList.toggle("show");
}

/* Set the width of the side navigation to 250px and the left margin of the page content to 250px */
function openNav() {
  document.getElementById("mySidenav").style.width = "15%";
  document.getElementById("chatDiv").style.marginRight = "288px";
  document.getElementById("chatDiv").style.width = "60%";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("chatDiv").style.marginRight = "0";
  document.getElementById("chatDiv").style.width = "100%";
}
