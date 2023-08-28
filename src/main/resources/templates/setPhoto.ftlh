<!DOCTYPE html>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
            margin-top: 40px;
        }

        .header {
            font-size: 30px;
            margin-bottom: 20px;
        }

        .profile-photo {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }

        .photo-preview {
            width: 200px;
            height: 200px;
            border-radius: 50%;
            object-fit: cover;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }

        .upload-btn {
            background-color: greenyellow;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-size: 18px;
            cursor: pointer;
        }

        .upload-btn:hover {
            background-color: lightgreen;
        }

        .upload-btn:focus {
            outline: none;
        }

        .submit-btn {
            background-color: greenyellow;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-size: 18px;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: lightgreen;
        }

        .submit-btn:focus {
            outline: none;
        }

        .footer {
            font-size: 14px;
            color: #6c757d;
        }
    </style>
    <title>Profile Job Seeker</title>
</head>
<body>


<form action="/photo" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple>
    <br><br>
    <input type="submit" value="Upload">
</form>
</body>
</html>
