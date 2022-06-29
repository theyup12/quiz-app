const startingMinutes = 15;
let time = startingMinutes * 60;
function countdown(seconds) {
    seconds = parseInt(sessionStorage.getItem("seconds"))||seconds;

    function tick() {
        seconds--;
        sessionStorage.setItem("seconds", seconds)
        let counter = document.getElementById("countdown");
        let current_minutes = parseInt(seconds/60);
        let current_seconds = seconds % 60;
        counter.innerHTML = "Time Left: " +current_minutes + ":" + (current_seconds < 10 ? "0" : "") + current_seconds;
        if( seconds > 0 ) {
            setTimeout(tick, 1000);
        }
    }
    tick();
}
countdown(time);
function reset_session(){
    sessionStorage.removeItem("seconds")
}