<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Nickname</label>
            <input type="text" class="form-control" name="username" placeholder="Nickname" value="${currentUser.username}" >
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="email" placeholder="Email" value="${currentUser.email}" >
        </div>
        <div class="form-group col-md-6">
            <label for="inputPhone">Phone number</label>
            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone number" value="${currentUser.getPhoneNumber()}">
        </div>
    </div>
    <#if currentUser??>
        <div class="list-group">
            <#list currentUser.userRecords as record>
                Record id:
                <a href="profile/${currentUser.username}/${record.recordId}" class="list-group-item list-group-item-action disabled">${record.recordId}</a>
            </#list>
        </div>
    </#if>
</@c.page>