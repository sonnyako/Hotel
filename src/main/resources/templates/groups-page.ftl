<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div style="width: 50%; margin: auto;margin-top: 10%;border: 2px solid darkgray;border-radius:10px">
    <table class="table table-hover">
        <thead style="padding:0px">
        <tr class="table-primary">
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Organization</th>
            <th scope="col">Delete</th>
            <th scope="col">Update</th>
        </tr>
        </thead>
        <div style="background: cornflowerblue ">
            <tbody>
            <#list groups as group>
                <tr>
                    <td>${group.id}</td>
                    <td>${group.name}</td>
                    <td>${group.organization.name}</td>
                </tr>
            </#list>
        </div>
        </tbody>
    </table>
    <a class="btn btn-success" href="/ui/groups/create" style="margin-left: 790px; width: 100px; margin-bottom: 10px">Create</a>
</div>
</body>
</html>
