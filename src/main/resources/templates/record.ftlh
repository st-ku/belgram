<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Record text</label>
            <input type="text" class="form-control" name="username" placeholder="Nickname" value="${currentRecord.textDescription}" >
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
</@c.page>