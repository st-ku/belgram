<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/new" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Text</label>
                <input type="text" class="form-control" name="textDescription" placeholder="Text">
            </div>
        </div>
        <div class="custom-file col-md-6">
            <input type="file" name="fileUpload" id="customFile" multiple/>
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary col-md-2">Create new Record</button>
    </form>

</@c.page>