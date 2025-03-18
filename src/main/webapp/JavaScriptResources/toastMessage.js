function showToast(message , type){
    let toast = document.getElementById("toast");
   let toastBody = document.getElementById("toast-body");
   toast.classList.add(`text-bg-${type}`)
   toastBody.innerText = message;
    const toastComponenty = new bootstrap.Toast(toast);
    toastComponenty.show();
}

const urlParams = new URLSearchParams(window.location.search);

if(urlParams.has("status")){
    const status = urlParams.get("status");
    const messageParam = urlParams.get("message");

    let message = status === "success"? "Signup Success You can now Login" : "Signup failed Try again later"
    if(messageParam){
        message = messageParam;
    }
    const type = status === "success" ? status : "danger";
    showToast(message , type) 
}
