// set tên nội dung
document.getElementById("contentName").innerText = "List Group";

$("#detail").hide();

getList();

function getList(){
    document.getElementById("listTable").innerHTML = "";

    $.ajax({
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group',
        type: 'GET',
        success:function(result){
            str = document.getElementById("listTable").innerHTML;
            str = str.concat("<table><tr><th style='width: 5%'></th><th style='width: 5%'>STT</th><th style='width: 25%'>Group Name</th><th style='width: 20%'>Member</th><th style='width: 25%'>Cretor</th><th style='width: 20%'>Create Date</th></tr>");
            cnt = 0;
            result.forEach(element => {
                cnt++;
                str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", element.id ,"'></td>"
                            ,"<td style='text-align: center'>", cnt ,"</td>"
                            ,"<td><p class='groupName' onclick='showDetail(", element.id ,")'>", element.groupName ,"</p></td>"
                            ,"<td style='text-align: center'>", element.memberNum ,"</td>"
                            ,"<td>", element.creator.name == undefined ? '' : element.creator.name ,"</td>"
                            ,"<td style='text-align: center'>", element.createDate.substring(0, 10) ,"</td>"                        
                            ,"</tr>");
            });
            str.concat("</table>")
            document.getElementById("listTable").innerHTML = str;
        }
    })
}

function search(){
    document.getElementById("listTable").innerHTML = "";
    var id = document.getElementById("search").value;

    $.ajax({
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group/' + id,
        type: 'GET',
        success:function(result){
            str = document.getElementById("listTable").innerHTML;
            str = str.concat("<table><tr><th style='width: 5%'></th><th style='width: 5%'>STT</th><th style='width: 25%'>Group Name</th><th style='width: 20%'>Member</th><th style='width: 25%'>Cretor</th><th style='width: 20%'>Create Date</th></tr>");
            cnt = 1;
            str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", result.id ,"'></td>"
                            ,"<td style='text-align: center'>", cnt ,"</td>"
                            ,"<td><p class='groupName' onclick='showDetail(", result.id ,")'>", result.groupName ,"</p></td>"
                            ,"<td style='text-align: center'>", result.memberNum ,"</td>"
                            ,"<td>", result.creator.name == undefined ? '' : result.creator.name ,"</td>"
                            ,"<td style='text-align: center'>", result.createDate.substring(0, 10) ,"</td>"                        
                            ,"</tr>");
            str.concat("</table>")
            document.getElementById("listTable").innerHTML = str;
        }
    })
}

function showCreateModal(){
    var modal = document.getElementById("createGroupModal");
    modal.style.display = "block";
}

function closeCreateGroupModal(){
    resetModalCreate();
    var modal = document.getElementById("createGroupModal");
    modal.style.display = "none";
}

function checkCreateGroup(){
    // lấy groupName
    var groupName = document.getElementById("inputGroupName").value;
    var check = true;

    $.ajax({
        async: false,
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group',
        type: 'GET',
        success:function(result){
            result.forEach(element => {
                if(element.groupName == groupName){
                    document.getElementById("errInfoCreate").innerText = "Group name is exits!";
                    check = false;
                }
            });
        }
    })

    if(check){
        createGroup();
    }
}

function createGroup(){
    // lấy groupName
    var groupName = document.getElementById("inputGroupName").value;

    // khai báo đối tượng
    var group = {
        "groupName": groupName,
        "memberNum": 11,
        "creator": {
         "name": "Nguyen A",
         "id": "1"
        },
        "createDate": "2022-02-05T13:46:04.851Z"
    }

    $.ajax({
        async: false,
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group',
        type: 'POST',
        data: group,
        success:function(result){
            if(result==undefined||result==null){
                alert("Có lỗi xảy ra");
                return;
            }else{
                alert("Thêm group thành công");
            }
        }
    })
    closeCreateGroupModal();
    getList();
}

function showDetail(id){
    $.ajax({
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group/' + id,
        type: 'GET',
        success:function(result){
            document.getElementById("groupDetailHeader").innerHTML = "<h3 id='groupName'>" + result.groupName + "<i class='far fa-pencil-alt pencil' onclick='showEditModal(" + id + ")'></i>" + "</h3>";
            document.getElementById("creatorName").innerText = result.creator.name == undefined ? '' : result.creator.name;
            document.getElementById("createDate").innerText = result.createDate.substring(0, 10);
            document.getElementById("member").innerText = result.memberNum;
        }
    })

    $("#list").hide();
    $("#detail").show();
}

function showEditModal(id){    
    document.getElementById("groupId").innerText = id;
    var modal = document.getElementById("editGroupModal");
    modal.style.display = "block";
}

function closeEditGroupModal(){
    resetModalEdit();
    var modal = document.getElementById("editGroupModal");
    modal.style.display = "none";
}

function checkEditGroup(){
    // lấy groupName
    var groupName = document.getElementById("inputEditGroupName").value;
    var check = true;

    $.ajax({
        async: false,
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group',
        type: 'GET',
        success:function(result){
            result.forEach(element => {
                if(element.groupName == groupName){
                    document.getElementById("errInfoEdit").innerText = "Group name is exits!";
                    check = false;
                }
            });
        }
    })

    if(check){
        editGroup();
    }
}

function editGroup(){
    // lấy group id
    var id = document.getElementById('groupId').textContent;
    // lấy groupName
    var groupName = document.getElementById("inputEditGroupName").value;    

    // khai báo đối tượng
    var group = {
        "groupName": groupName,
        "memberNum": 30,
        "creator": {
            "name": "Nguyen A",
            "id": "1"
        },
        "createDate": "2022-02-05T11:31:14.525Z",
        "id": "6"
    }

    $.ajax({
        async: false,
        url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group/' + id,
        type: 'PUT',
        data: group,
        success:function(result){
            if(result == undefined || result == null){
                alert("Có lỗi xảy ra");
                return;
            }else{
                alert("Sửa group thành công");
            }
        }
    })

    closeEditGroupModal();
    $("#list").show();
    $("#detail").hide();
    getList();

}

function showDelConfirm(){
    if($('input[name="checkRow"]:checked').length == 0){
        alert("Hãy chọn group");
        return;
    }
    var modal = document.getElementById("deleteGroupModal");
    modal.style.display = "block";
}

function closeDeleteGroupModal(){
    var modal = document.getElementById("deleteGroupModal");
    modal.style.display = "none";
}

function deleteGroup(){
    var checkDel = true;
    $('input[name="checkRow"]:checked').each(function() {
        $.ajax({
            async: false,
            url: 'https://61ed2685f3011500174d22e6.mockapi.io/api/v1/group/' + this.id,
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
        alert("Có lỗi xảy ra");
    }else{
        alert("Xóa group thành công");
    }

    closeDeleteGroupModal();
    getList();
}

function resetModalEdit(){
    document.getElementById("inputEditGroupName").value = "";
    document.getElementById("errInfoEdit").innerText = "";
    document.getElementById("groupId").innerText = "";
}

function resetModalCreate(){
    document.getElementById("inputGroupName").value = "";
    document.getElementById("errInfoCreate").innerText = "";
}

