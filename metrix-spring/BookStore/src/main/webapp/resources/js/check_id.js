window.addEventListener("load", () => {
    const button = document.getElementById("check_id");
    const button_sync = document.getElementById("check_id_sync");
   
    //비동기 중복확인
    button.addEventListener("click", () => {
        const id = document.querySelector("input[name='custid']").value;

        const xhr = new XMLHttpRequest();

        xhr.open("GET", `checkId/${id}`, true);
        xhr.onreadystatechange = () => {
            if(xhr.readyState == xhr.DONE){
                if(xhr.status == 200) {
                    alert(xhr.responseText);
                }
            }
        };
        xhr.send();
    });
    
    //동기 중복확인
    button_sync.addEventListener("click", () => {
        const id = document.querySelector("input[name='custid']").value;

        const xhr = new XMLHttpRequest();

        xhr.open("GET", `checkId/${id}`, false);
        xhr.send();
        alert(xhr.responseText);
    });
});