const startingMinutes = 15;
let time = startingMinutes * 60;
// const COUNTER_KEY ='my-counter';
const countdownEl = document.getElementById('countdown');

setInterval(updateCountdown, 1000)
function updateCountdown(){
    const  minutes = Math.floor(time / 60);
    let seconds = time % 60;

    seconds = seconds < 10 ? '0' + seconds : seconds;
    countdownEl.innerHTML = minutes+":"+seconds;
    // if((time--) > 0){
    //     window.sessionStorage.setItem(COUNTER_KEY, time.toString());
    // }else{
    //     window.sessionStorage.removeItem(COUNTER_KEY);
    //     clearInterval(timer);
    // }
    time--;
}