// const
const tableHeader = "<table><tr><th style='width: 5%'></th><th style='width: 5%'>STT</th><th style='width: 25%'>Group Name</th><th style='width: 20%'>Member</th><th style='width: 25%'>Cretor</th><th style='width: 20%'>Create Date</th></tr>";
const apiUrl = "https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group";
const sysErrMsg = "An error occurred, please check again!";
const duplicateErrMsg = "Group name is exits!";

// set tên nội dung
$("#contentName").text("List Group");

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
                            ,"<td><a href='#' class='groupName' onclick='showDetail(", element.id ,")'>", element.groupName ,"</a></td>"
                            ,"<td style='text-align: center'>", element.memberNum ,"</td>"
                            ,"<td>", element.creator.name == undefined ? '' : element.creator.name ,"</td>"
                            ,"<td style='text-align: center'>", element.createDate.substring(0, 10) ,"</td>"                        
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
                                ,"<td><a class='groupName' onclick='showDetail(", result.id ,")'>", result.groupName ,"</a></td>"
                                ,"<td style='text-align: center'>", result.memberNum ,"</td>"
                                ,"<td>", result.creator.name == undefined ? '' : result.creator.name ,"</td>"
                                ,"<td style='text-align: center'>", result.createDate.substring(0, 10) ,"</td>"                        
                                ,"</tr>");
                str.concat("</table>")
                $("#listTable").html(str);
            }
        })
    }else{
        getList();
    }
}

// show modal thêm group
function showCreateGroupModal(){
    $("#groupId").text("");
    $("#modalName").text("Create Group");
    $("#groupEditModal").show("slow");
    $("#inputGroupName").focus();
}

// show modal sửa group
function showEditGroupModal(id){    
    $("#groupId").text(id);
    $("#modalName").text("Edit Group");
    $("#groupEditModal").show("slow");
    $("#inputGroupName").focus();
}

// đóng modal thêm/sửa group
function closeGroupModal(){
    $("#inputGroupName").val("");
    $("#errInfo").text("");
    $("#groupId").text("");

    $("#groupEditModal").hide("slow");
}

// show detail
function showDetail(id){
    $.ajax({
        url: apiUrl + "/" + id,
        type: 'GET',
        success:function(result){
            $("#groupDetailHeader").html(
                "<h3 id='groupName'>" + result.groupName + "<i class='far fa-pencil-alt pencil' onclick='showEditGroupModal(" + id + ")'></i>" + "</h3>"
            );
            $("#creatorName").text(result.creator.name == undefined ? '' : result.creator.name);
            $("#createDate").text(result.createDate.substring(0, 10));
            $("#member").text(result.memberNum);
        }
    })

    $("#list").hide();
    $("#detail").show();
}

// kiểm tra trùng tên group khi thêm/sửa
function checkGroupNameDuplication(groupName){
    var check = true;
    $.ajax({
        async: false,
        url: apiUrl,
        type: 'GET',
        success:function(result){
            result.forEach(element => {
                if(element.groupName == groupName){
                    check = false;
                }
            });
        }
    })

    return check;
}

// event của btton save
$("#btnSave").click(function(){
    var groupName = $("#inputGroupName").val();
    var check = checkGroupNameDuplication(groupName);
    if(check == false){
        $("#errInfo").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("groupId").textContent;
        if(id != ""){
            // Update
            editGroup(id, groupName);
        }else{
            // Create
            createGroup(groupName);
        }
    }
});

function saveGroup(){
    var groupName = $("#inputGroupName").val();
    var check = checkGroupNameDuplication(groupName);
    if(check == false){
        $("#errInfo").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("groupId").textContent;
        if(id != ""){
            // Update
            editGroup(id, groupName);
        }else{
            // Create
            createGroup(groupName);
        }
    }
}

// Thêm group
function createGroup(groupName){
    var now = new Date();
    // khai báo đối tượng
    var group = {
        "groupName": groupName,
        "memberNum": 0,
        "creator": {
            "name": "Nguyen A",
            "id": "1"
        },
        "createDate": now.toISOString()
    }

    $.ajax({
        async: false,
        url: apiUrl,
        type: 'POST',
        contentType:"application/json;charset=utf-8",
        data: JSON.stringify(group),
        success:function(result){
            if(result == undefined || result == null){
                showInfomation(true, sysErrMsg)
                return;
            }else{
                showInfomation(false, "Add group success")
            }
        }
    })
    closeGroupModal();
    getList();
}

// Sửa group
function editGroup(id, groupName){
    // khai báo đối tượng
    var group = {
        groupName: groupName
    }

    $.ajax({
        async: false,
        url: apiUrl + "/" + id,
        type: 'PUT',
        data: group,
        success:function(result){
            if(result == undefined || result == null){
                showInfomation(true, sysErrMsg)
                return;
            }else{
                showInfomation(false, "Update group success")
            }
        }
    })

    closeGroupModal();
    $("#list").show();
    $("#detail").hide();
    getList();
}

// xóa group
function showDelConfirm(){
    if($('input[name="checkRow"]:checked').length == 0){
        showInfomation(true, "Hãy chọn group!")
        return;
    }
    $("#deleteGroupModal").show("slow");
}

function closeDeleteGroupModal(){
    $("#deleteGroupModal").hide("slow");
}

function deleteGroup(){
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
        showInfomation(false, "Delete group success")
    }

    closeDeleteGroupModal();
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