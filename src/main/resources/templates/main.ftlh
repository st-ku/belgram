<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>

<#if userList??>
<div class="list-group">
  <#list userList as user>
     <a href="profile/${user.username}" class="list-group-item list-group-item-action disabled">${user.username}</a>
  </#list>
</div>
</#if>
</@c.page>