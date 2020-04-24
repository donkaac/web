/**
 * Created by Achi on 4/23/2020.
 */
var REST_PATH = "";
function auth(email, password) {
    $.ajax({
        url: REST_PATH+"/auth",
        type: "post",
        dataType: "application/json",
        data: {email: email, password: password},
        success: function (data) {
            console.log(data);
            sessionStorage.setItem("rest-token", data.responseText);
            return false;
        },
        error: function (error) {
            return false;
        }
    });
}

function getToken() {
    let token = sessionStorage.getItem("rest-token");
    if(token == null){
        throw new Error("REST Authentication Token Error!");
    }else{
        return token;
    }
}