// const
const tableHeader = "<table><tr><th style='width: 5%'><input type='checkbox' name='checkAll'></th><th style='width: 5%'>STT</th><th style='width: 90%'>Department Name</th></tr>";
const apiUrl = "http://localhost:8080/api/v1/departments";
const sysErrMsg = "An error occurred, please check again!";
const duplicateErrMsg = "Department name is exits!";



// set tên nội dung
$("#contentName").text("List Department");

// ẩn phần chi tiết
$("#detail").hide();

// lấy dữ liệu
getList();

// hàm lấy dữ liệu
function getList(){    
    $("#list").show();
    $("#detail").hide();
    $("#search").val("");
    $("#listTable").html("");
    $.ajax({
        url: apiUrl,
        type: "GET",
        success:function(result){
            var str = "";
            str = str.concat(tableHeader);
            cnt = 0;
            result.forEach(element => {
                cnt++;
                str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", element.id ,"'></td>"
                            ,"<td style='text-align: center'>", cnt ,"</td>"
                            ,"<td><a class='departmentName' onclick='showEditDepartmentModal(", element.id ,")'>", element.name ,"</a></td>"                       
                            ,"</tr>");
            });
            str.concat("</table>")
            $("#listTable").html(str);
        }
    })
}

// hàm lấy dữ liệu theo id
function searchById(){
    var id = $("#search").val();
    if(id != ""){
        $("#listTable").html("");
        $.ajax({
            url: apiUrl + '/' + id,
            type: 'GET',
            success:function(result){
                var str = "";
                str = str.concat(tableHeader);
                cnt = 1;
                str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", result.id ,"'></td>"
                                ,"<td style='text-align: center'>", cnt ,"</td>"
                                ,"<td><a class='departmentName' onclick='showEditDepartmentModal(", result.id ,")'>", result.name ,"</a></td>"                      
                                ,"</tr>");
                str.concat("</table>")
                $("#listTable").html(str);
            }
        })
    }else{
        getList();
    }
}

// show modal thêm department
function showCreateDepartmentModal(){
    $("#departmentId").text("");
    $("#modalName").text("Create Department");
    $("#departmentEditModal").show("slow");
    $("#inputDepartmentName").focus();
}

// show modal sửa department
function showEditDepartmentModal(id){    
    $("#departmentId").text(id);
    $("#modalName").text("Edit Department");
    $("#departmentEditModal").show("slow");
    $("#inputDepartmentName").focus();
}

// đóng modal thêm/sửa department
function closeDepartmentModal(){
    $("#inputDepartmentName").val("");
    $("#errInfo").text("");
    $("#departmentId").text("");

    $("#departmentEditModal").hide("slow");
}

// kiểm tra trùng tên department khi thêm/sửa
function checkDepartmentNameDuplication(departmentName){
    var check = true;
    $.ajax({
        async: false,
        url: apiUrl,
        type: 'GET',
        success:function(result){
            result.forEach(element => {
                if(element.departmentName == departmentName){
                    check = false;
                }
            });
        }
    })

    return check;
}

// event của btton save
$("#btnSave").click(function(){
    var departmentName = $("#inputDepartmentName").val();
    var check = checkDepartmentNameDuplication(departmentName);
    if(check == false){
        $("#errInfo").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("departmentId").textContent;
        if(id != ""){
            // Update
            editDepartment(id, departmentName);
        }else{
            // Create
            createDepartment(departmentName);
        }
    }
});

function saveDepartment(){
    var departmentName = $("#inputDepartmentName").val();
    var check = checkDepartmentNameDuplication(departmentName);
    if(check == false){
        $("#errInfo").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("departmentId").textContent;
        if(id != ""){
            // Update
            editDepartment(id, departmentName);
        }else{
            // Create
            createDepartment(departmentName);
        }
    }
}

// Thêm department
function createDepartment(departmentName){
    // khai báo đối tượng
    var department = {
        "name": departmentName
    }

    $.ajax({
        async: false,
        url: apiUrl,
        type: 'POST',
        contentType:"application/json;charset=utf-8",
        data: JSON.stringify(department),
        success:function(result){
            if(result == undefined || result == null){
                showInfomation(true, sysErrMsg)
                return;
            }else{
                showInfomation(false, "Add department success")
            }
        }
    })
    closeDepartmentModal();
    getList();
}

// Sửa department
function editDepartment(id, departmentName){
    // khai báo đối tượng
    var department = {
        "name": departmentName
    }

    $.ajax({
        async: false,
        url: apiUrl + "/" + id,
        type: 'PUT',
        data: JSON.stringify(department),
        contentType: "application/json;charset=utf-8",
        success:function(result){
            if(result == undefined || result == null){
                showInfomation(true, sysErrMsg)
                return;
            }else{
                showInfomation(false, "Update department success")
            }
        }
    })

    closeDepartmentModal();
    $("#list").show();
    $("#detail").hide();
    getList();
}

// xóa department
function showDelConfirm(){
    if($('input[name="checkRow"]:checked').length == 0){
        showInfomation(true, "Hãy chọn department!")
        return;
    }
    $("#deleteDepartmentModal").show("slow");
}

function closeDeleteDepartmentModal(){
    $("#deleteDepartmentModal").hide("slow");
}

function deleteDepartment(){
    var checkDel = true;
    $('input[name="checkRow"]:checked').each(function() {
        $.ajax({
            async: false,
            url: apiUrl + "/" + this.id,
            type: 'DELETE',
            data: null,
            success:function(result){
                if(result==undefined||result==null){
                    checkDel = false;
                }
            }
        })
     });

    if(checkDel == false){
        showInfomation(true, sysErrMsg)
    }else{
        showInfomation(false, "Delete department success")
    }

    closeDeleteDepartmentModal();
    getList();
}

// show Infomation
function showInfomation(isErr, infoMsg){
    if(isErr){
        $("#infoName").html(
            "<h3 id='infoName'><i class='fas fa-times-circle errInfoIcon'></i> Error</h3>"
        );
    }else{
        $("#infoName").html(
            "<h3 id='infoName'><i class='fas fa-check-circle infoIcon'></i> Info</h3>"
        );
    }
    
    $("#infoContent").text(infoMsg);

    $("#infoMsg").show();
}

// hide Infomation
function closeInfoMsg(){
    $("#infoName").html(
        "<h3 id='infoName'></h3>"
    );    
    $("#infoContent").text("");

    $("#infoMsg").hide();
}