<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fafafa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .logo {
            text-align: center;
            margin-bottom: 20px;
        }

        .logo img {
            width: 120px;
        }

        .form-switch {
            text-align: center;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #dbdbdb;
            border-radius: 4px;
            background-color: #fafafa;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #0095f6;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        p {
            text-align: center;
            margin-top: 16px;
            color: #999;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="logo">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWo4v-BaVbLHGYKpGxNQBjiOQpqrJmTAgvLA&usqp=CAU">
    </div>
    <form action="/login" method="post">
        <input type="text" placeholder="Email" name="username">
        <input type="password" placeholder="Password" name="password">
        <button type="submit">Login</button>
    </form>
    <div class="form-switch">
        <p>Do you have an account? <a href="/register">Sign up</a></p>
    </div>
</div>
</body>
</html>
