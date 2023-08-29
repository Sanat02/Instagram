<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.4.6/tailwind.min.css'>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>

        .pb-full {
            padding-bottom: 100%;
        }

        .bioclass {
            color: #8E8E8E;
        }

        .search-bar:focus + .fa-search {
            display: none;
        }

        #act {
            color: dodgerblue;
        }

        @media screen and (min-width: 768px) {
            .post:hover .overlay {
                display: block;
            }
        }

        .post {
            width: 100%;
            height: auto;
            background: #fff;
            border: 1px solid #dfdfdf;
            margin-top: 40px;
        }

        .info {
            width: 100%;
            height: 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
        }

        .info .username {
            width: auto;
            font-weight: bold;
            color: #000;
            font-size: 14px;
            margin-left: 10px;
        }

        .info .options {
            height: 10px;
            cursor: pointer;
        }

        .info .user {
            display: flex;
            align-items: center;
        }

        .info .profile-pic {
            height: 40px;
            width: 40px;
            padding: 0;
            background: none;
        }

        .info .profile-pic img {
            border: none;
        }

        .post-image {
            width: 100%;
            height: 500px;
            object-fit: cover;
        }

        .post-content {
            width: 100%;
            padding: 20px;
        }

        .likes {
            font-weight: bold;
        }

        .description {
            margin: 10px 0;
            font-size: 14px;
            line-height: 20px;
        }

        .description span {
            font-weight: bold;
            margin-right: 10px;
        }

        .post-time {
            color: rgba(0, 0, 0, 0.5);
            font-size: 12px;
        }

        .comment-wrapper {
            width: 100%;
            height: 50px;
            border-radius: 1px solid #dfdfdf;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .comment-wrapper .icon {
            height: 60px;
        }

        .comment-box {
            width: 80%;
            height: 100%;
            border: none;
            outline: none;
            font-size: 14px;
        }

        .comment-btn,
        .action-btn {
            width: 70px;
            height: 100%;
            background: none;
            border: none;
            outline: none;
            text-transform: capitalize;
            font-size: 16px;
            color: rgb(0, 162, 255);
            opacity: 0.5;
        }

        .reaction-wrapper {
            width: 100%;
            height: 50px;
            display: flex;
            margin-top: -20px;
            align-items: center;
        }

        .reaction-wrapper .icon {
            height: 25px;
            margin: 0;
            margin-right: 20px;
        }

        .reaction-wrapper .icon.save {
            margin-left: auto;
        }

        .main {
            width: 100%;
            padding: 100px 0;
            display: flex;
            justify-content: center;
            margin-top: 50px;
        }

        .wrapper {
            width: 70%;
            max-width: 1000px;
            display: grid;
            grid-template-columns: 60% 40%;
            grid-gap: 30px;
        }

        .left-col {
            display: flex;
            flex-direction: column;
        }

        .status-wrapper {
            width: 100%;
            height: 120px;
            background: #fff;
            border: 1px solid #dfdfdf;
            border-radius: 2px;
            padding: 10px;
            padding-right: 0;
            display: flex;
            align-items: center;
            overflow: hidden;
            overflow-x: auto;
        }

        .status-wrapper::-webkit-scrollbar {
            display: none;
        }

        .status-card {
            flex: 0 0 auto;
            width: 80px;
            max-width: 80px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-right: 15px;
        }

        .profile-pic {
            width: 70px;
            height: 70px;
            border-radius: 50%;
            overflow: hidden;
            padding: 3px;
            background: linear-gradient(45deg, rgb(255, 230, 0), rgb(255, 0, 128) 80%);
        }

        .profile-pic img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 50%;
            border: 2px solid #fff;
        }

        .username {
            width: 100%;
            overflow: hidden;
            text-align: center;
            font-size: 12px;
            margin-top: 5px;
            color: rgba(0, 0, 0, 0.5)
        }

        .heart-icon {
            font-size: 27px;
            color: #e2dbdb;
            border-radius: 50%;
            padding: 10px;
            cursor: pointer;
            transition: all 0.2s;
        }

        .heart-icon:hover {
            font-size: 32px;
            color: red;
        }

        .heart-icon2 {
            font-size: 27px;
            color: red;
            border-radius: 50%;
            padding: 10px;
            cursor: pointer;
            transition: all 0.2s;
        }

        .heart-icon2:hover {
            font-size: 32px;
            color: #e2dbdb;;
        }

        .chat-container {
            flex: 1;
            max-height: 400px;
            overflow-y: auto;
        }

        .chat {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-height: 100px;
            overflow-y: auto;
        }

        .message {
            margin-bottom: 10px;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }

        .message .sender {
            font-weight: bold;
            color: greenyellow;
        }

        .message .date {
            font-size: 12px;
            color: #777;
            margin-bottom: 5px;
        }

        .input-group {
            margin-top: 20px;
        }

        .input-group input {
            width: 80%;
            border-radius: 4px;
            padding: 8px;
        }

        .input-group button {
            width: 20%;
            border-radius: 4px;
            margin-left: 10px;
        }

        .message-separator {
            width: 100%;
            border-top: 1px solid #ddd;
            margin: 10px 0;
        }


    </style>
</head>
<body>

<nav class="border-b px-4 py-2 bg-white">
    <div class="flex flex-wrap items-center justify-between md:justify-around">
        <img class="h-10"
             src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/150px-Instagram_logo.svg.png"
             alt="instagram">

        <#if account??>
            <div class="space-x-4">
                <a id="logout" class="inline-block bg-blue-500 px-2 py-1 text-white font-semibold
                             text-sm rounded" href="/logout">Log out</a>
            </div>
        <#else>
            <div class="space-x-4">
                <a class="inline-block bg-blue-500 px-2 py-1 text-white font-semibold
                             text-sm rounded" href="/login">Sign in</a>

                <a class="inline-block bg-blue-500 px-2 py-1 text-white font-semibold
                             text-sm rounded" href="/register">Sign up</a>
            </div>
        </#if>
    </div>
</nav>

<#if account??>
    <section class="main">
        <div class="wrapper">
            <div class="left-col">
                <div class="status-wrapper">
                    <div class="status-card">
                        <div class="profile-pic"><img src="img/cover 1.png" alt=""></div>
                        <p class="username">user_name_1</p>
                    </div>
                    <div class="status-card">
                        <div class="profile-pic"><img src="img/cover 2.png" alt=""></div>
                        <p class="username">user_name_2</p>
                    </div>
                    <div class="status-card">
                        <div class="profile-pic"><img src="img/cover 3.png" alt=""></div>
                        <p class="username">user_name_3</p>
                    </div>
                </div>

                <#list followers as follower>
                    <#list follower.user.images as image>

                        <div class="post">
                            <div class="info">
                                <div class="user">
                                    <div class="profile-pic"><img src="/posts/photo/${follower.user.id}" alt=""></div>
                                    <p class="username">${follower.user.accountName}</p>
                                </div>


                            </div>
                            <img src="/posts/${image.id}/${follower.user.id}" class="post-image" alt="">
                            <div class="post-content">
                                <div class="reaction-wrapper">
                                    <img src="img/like.PNG" class="icon" alt="">
                                    <img src="img/comment.PNG" class="icon" alt="">
                                    <img src="img/send.PNG" class="icon" alt="">
                                    <img src="img/save.PNG" class="save icon" alt="">
                                </div>
                                <#if image.isLiked()>
                                    <div class="heart-icon2" id="image${image.getId()}" data-fileid="${image.getId()}">
                                        <i class="fas fa-heart"></i>
                                    </div>
                                <#else>
                                    <div class="heart-icon" id="image${image.getId()}" data-fileid="${image.getId()}">
                                        <i class="fas fa-heart"></i>
                                    </div>
                                </#if>
                                <p class="likes">${image.likes} likes </p>
                                <p class="description"><span>${follower.user.accountName} </span> Lorem ipsum dolor sit
                                    amet consectetur,
                                    adipisicing
                                    elit. Pariatur tenetur veritatis placeat, molestiae impedit aut provident eum quo
                                    natus
                                    molestias?</p>
                            </div>

                            <div id="chat" class="chat" data-imageid="${image.id}">

                            </div>

                            <div class="comment-wrapper">
                                <form id="chat_form">
                                    <input type="hidden" name="followerId" value="${follower.user.id}">
                                    <input type="hidden" name="imageId" value="${image.id}">
                                    <input id="message${image.id}" type="text" placeholder="Type a message" required>
                                    <input type="submit" value="Submit">
                                </form>
                            </div>
                        </div>

                    </#list>
                </#list>
            </div>
        </div>
    </section>
</#if>


<nav class="bg-white border-t fixed bottom-0 w-full">
    <ul class="flex justify-around py-2">
        <li class="flex-1 text-center">
            <a href="#" id="act" class="text-gray-600 hover:text-blue-500">
                <i class="fas fa-home text-xl"></i>
            </a>
        </li>
        <li class="flex-1 text-center">
            <a href="/users" class="text-gray-600 hover:text-blue-500">
                <i class="fas fa-search text-xl"></i>
            </a>
        </li>
        <#if account??>
            <li class="flex-1 text-center">
                <a href="/images" class="text-gray-600 hover:text-blue-500">
                    <i class="far fa-plus-square text-xl"></i>
                </a>
            </li>

            <li class="flex-1 text-center">
                <a href="/profile" class="text-gray-600 hover:text-blue-500">
                    <i class="far fa-user text-xl"></i>
                </a>
            </li>
        </#if>
    </ul>

</nav>
<script>

    document.addEventListener("DOMContentLoaded", function () {
        const heartIcons = document.querySelectorAll('.heart-icon');
        const heartIcons2 = document.querySelectorAll('.heart-icon2');

        if (heartIcons) {
            heartIcons.forEach(function (heartIcon) {
                heartIcon.addEventListener("click", function () {
                    const imageId = heartIcon.getAttribute("data-fileid");
                    fetch(`/like/` + imageId, {
                        method: 'GET'
                    })
                        .then(response => {
                            if (response.ok) {
                                location.reload();
                            } else {
                                console.error('Error liking post:', response.status);
                            }
                        })
                        .catch(error => {
                            console.error('Error liking post:', error);
                        });

                });
            });
        }

        if (heartIcons2) {
            heartIcons2.forEach(function (heartIcon) {
                heartIcon.addEventListener("click", function () {
                    const imageId = heartIcon.getAttribute("data-fileid");
                    fetch(`/like/` + imageId, {
                        method: 'DELETE'
                    })
                        .then(response => {
                            if (response.ok) {
                                location.reload();
                            } else {
                                console.error('Error liking post:', response.status);
                            }
                        })
                        .catch(error => {
                            console.error('Error liking post:', error);
                        });

                });
            });
        }
        const baseUrl = 'http://localhost:8087/comment';
        const chatForms = document.querySelectorAll('#chat_form');
        const storedUser = readUser();

        const headers = new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + btoa(storedUser.username + ':' + storedUser.password)
        });

        async function getMessages() {
            let response = await fetch(
                baseUrl,
                {
                    method: 'GET',
                    headers: headers
                }
            )
            return await response.json()
        }


        if (chatForms) {
            chatForms.forEach(function (chatForm) {
                chatForm.addEventListener("submit", function (event) {

                    event.preventDefault();

                    const followerId = chatForm.querySelector('input[name="followerId"]').value;
                    const imageId = chatForm.querySelector('input[name="imageId"]').value;
                    const messageInput = chatForm.querySelector('#message' + imageId);

                    const message = messageInput.value.trim();

                    if (message === '') {
                        return;
                    }

                    const formData = new FormData(chatForm);
                    formData.append('followerId', followerId);
                    formData.append('imageId', imageId);
                    formData.append('comment', message);

                    const formDataObject = {};
                    formData.forEach((value, key) => {
                        formDataObject[key] = value;
                    });

                    const json = JSON.stringify(formDataObject);

                    fetch(
                        baseUrl,
                        {
                            method: 'POST',
                            body: json,
                            headers: headers
                        }
                    );

                    // Clear the message input
                    messageInput.value = '';


                });


            });
        }

        function readUser() {
            let userAsJson = localStorage.getItem('user');
            let user = JSON.parse(userAsJson);
            return user;
        }

        const chatContainers = document.querySelectorAll('.chat');
        chatContainers.forEach(function (chatContainer) {
            const imageId = chatContainer.getAttribute('data-imageid');

            window.addEventListener('load', async () => {
                setInterval(async () => {

                    const response = await getMessages();
                    const messages = JSON.parse(JSON.stringify(response));


                    chatContainer.innerHTML = '';

                    for (let messageElement of messages) {
                        const messageDiv = document.createElement('div');
                        messageDiv.className = 'message';

                        const senderP = document.createElement('p');
                        senderP.className = 'sender';
                        senderP.textContent = messageElement.senderName;
                        messageDiv.appendChild(senderP);

                        const textP = document.createElement('p');
                        textP.textContent = messageElement.comment;
                        messageDiv.appendChild(textP);

                        const dateP = document.createElement('p');
                        dateP.className = 'date';
                        dateP.textContent = messageElement.timestamp;
                        messageDiv.appendChild(dateP);

                        chatContainer.appendChild(messageDiv);

                        const separatorDiv = document.createElement('div');
                        separatorDiv.className = 'message-separator';
                        chatContainer.appendChild(separatorDiv);
                    }
                }, 5000);
            });

            async function getMessages() {
                let response = await fetch(
                    baseUrl + "/" + imageId,
                    {
                        method: 'GET',
                        headers: headers
                    }
                )
                return await response.json()
            }
        });

        document.getElementById('logout').addEventListener('click', () => {
            localStorage.removeItem('user')
        })


    })
</script>
</body>
</html>
