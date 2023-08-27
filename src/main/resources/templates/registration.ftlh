<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram Registration</title>
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
    <form action="/register" method="post">
        <input type="text" placeholder="Email" name="email">
        <input type="text" placeholder="Full Name" name="full_name">
        <input type="text" placeholder="Username" name="account_name">
        <input type="password" placeholder="Password" name="password">
        <button type="submit">Sign Up</button>
    </form>
    <p>By signing up, you agree to our Terms, Data Policy, and Cookies Policy.</p>
    <div class="form-switch">
        <p>Have an account? <a href="/login">Sign in</a></p>
    </div>
</div>
</body>
</html>
