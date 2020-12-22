<#import "parts/common.ftlh" as c>
<@c.page>
<form action="/registration/send" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User Name :</label>
            <div class="col-sm-6">
                <input type="text" name="username" required="required" pattern="[A-Za-z0-9]{1,20}" value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="User name" />
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" required="required" pattern="[A-Za-z0-9]{1,20}"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password" />
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
    <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password confirm:</label>
                <div class="col-sm-6">
                    <input type="password" name="passwordConfirm" required="required" pattern="[A-Za-z0-9]{1,20}"
                           class="form-control ${(passwordConfirmError??)?string('is-invalid', '')}"
                           placeholder="Retype password" />
                    <#if passwordConfirmError??>
                        <div class="invalid-feedback">
                            ${passwordConfirmError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Phone:</label>
                <div class="col-sm-6">
                    <input type="tel" name="phoneNumber" required="required" pattern="[A-Za-z0-9]{1,20}" value="<#if user??>${user.phoneNumber}</#if>"
                           class="form-control"
                           placeholder="375*********" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" value="<#if user??>${user.email}</#if>"
                           class="form-control ${(emailError??)?string('is-invalid', '')}"
                           placeholder="some@some.com" />
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>


        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Register</button>


</@c.page>