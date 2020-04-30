
$("#menu-tabel").DataTable();
function  loadAll() {
    $.ajax({

        url : REST_PATH + "/menu",
        type : "get",
        success : function (data) {
            let data_set="";
            for(let i of data){
                data_set +=`<tr>
                <td>${i.name}</td>
                </tr>`
            }
            $("#menu-all").html(data_set);
        },
        error : function () {

        }
    });
}


function loadTopics(){
    $.ajax({
        url: REST_PATH + "/menu",
        type: "get",
        success : function (data) {
            let data_set="";
            for(let i of data){
                data_set +=`<tr>
                <td>${i.name}</td>
                <td><a href="" class="btn btn-xs btn-default"><i class="fa fa-edit"></i> Edit</a>
                <a href="" class="btn btn-xs btn-default"><i class="fa fa-trash"></i> Delete</a></td>
                </tr>`
            }
            $("#menu-names").html(data_set);
        },
        error : function () {

        }
    });
}

function loadTopicsForSubCategory(){
    $.ajax({
        url: REST_PATH + "/menu",
        type: "get",
        success : function (data) {
            let data_set="";
            for(let i of data){
                data_set +=`<option>${i.name}</option>`
            }
            $(".menu-names-to-category").html(data_set);
        },
        error : function () {

        }
    });
}