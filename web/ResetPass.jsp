<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CodePen - Password reset form</title>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="css/resetpass.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="panel">
            <img class="panel__avatar" src="${sessionScope.acc.image}" alt="avatar" />
            <form action="resetpass" method="post" class="inputs">
                <div class="inputs__item">
                    <h3 style="color: #eb833e">${notice}</h3>
                    <label for="new-password" class="inputs__label">New password</label>
                    <input type="password" class="inputs__input" name="new-password" value="password" />
                </div>
                <div class="inputs__item inputs__item--new">
                    <label for="confirm-password" class="inputs__label">Confirm password</label>
                    <input type="password" class="inputs__input" name="confirm-password" value="drowssap" />
                </div>
                <div class="inputs__item inputs__item--cta">
                    <input type="submit" class="btn" value="RESET" />
                </div>
            </form>
        </div>
        <!-- partial -->

    </body>
</html>
