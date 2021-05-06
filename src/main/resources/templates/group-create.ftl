<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Create</h1>
<div div class="mb-3" style="width: 50%; margin: auto;margin-top: 10%">
    <fieldset style="border: 2px solid darkgray; padding: 20px; border-radius:10px ">
        <legend>Create group</legend>
        <form name="form" action="" method="post">
            <label  class="form-label">Name:</label>
            <input class="form-control"<@spring.formInput  "form.name" "" "text"/>
            <br>
            <label  class="form-label">Organization:</label>
            <@spring.formSingleSelect  "form.organization",organizations, ""/>
            <br>

            <button type="submit" class="btn btn-success" style="margin-left: 690px; width: 200px">Create</button>
        </form>
    </fieldset>
</div>
</body>
</html>