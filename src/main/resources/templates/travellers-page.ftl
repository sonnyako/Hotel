<#import "/spring.ftl" as spring/>
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
                <th scope="col">Birthday</th>
                <th scope="col">Document Number</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Delete</th>
                <th scope="col">Update</th>
            </tr>
            </thead>
        <div style="background: cornflowerblue ">
            <tbody>
            <#list travellers as traveller>
                <tr>
                    <td>${traveller.id}</td>
                    <td>${traveller.name}</td>
                    <td>${traveller.birthday}</td>
                    <td>${traveller.documentNumber}</td>
                    <td>${traveller.phoneNumber}</td>
                    <td><a href="/ui/travellers/delete/${traveller.id}">
                            <button type="button" class="btn btn-outline-danger">Del</button>
                        </a></td>
                    <td><a href="/ui/travellers/update/${traveller.id}">
                            <button type="button" class="btn btn-outline-primary">Upd</button>
                        </a></td>

                </tr>
            </#list>
        </div>
        </tbody>
    </table>
    <a class="btn btn-success" href="/ui/travellers/create" style="margin-left: 790px; width: 100px; margin-bottom: 10px">Create</a>
</div>
</body>
</html>