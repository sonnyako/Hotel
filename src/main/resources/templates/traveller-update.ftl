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
<div div class="mb-3" style="width: 50%; margin: auto;margin-top: 10%">

    <fieldset style="border: 2px solid darkgray; padding: 20px; border-radius:10px ">
        <legend>Update traveller</legend>
        <form name="traveller" action="" method="post">
            <label class="form-label">Id:</label>
            <br> <input class="form-control" <@spring.formInput  "form.id" "" "text"/>

            <label class="form-label">Name:</label>
            <input class="form-control" <@spring.formInput  "form.name" "" "text"/>
            <br>

            <label class="form-label">Day of birth:</label>
            <input class="form-control" <@spring.formInput  "form.birthday" "" "date"/>
            <br>

            <label class="form-label">Document Number:</label>
            <input class="form-control" <@spring.formInput  "form.documentNumber" "" "text"/>
            <br>

            <label class="form-label">Phone Number:</label>
            <input class="form-control" <@spring.formInput  "form.phoneNumber" "" "text"/>
            <br>

            <button type="submit" class="btn btn-primary" style="margin-left: 690px; width: 200px"
                    data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>

        </form>
    </fieldset>
</div>
</body>
</html>