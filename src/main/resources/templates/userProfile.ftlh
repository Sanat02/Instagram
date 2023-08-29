<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Users</title>

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.4.6/tailwind.min.css'>
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

        .download-btn {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 5px 10px;
            cursor: pointer;
            text-decoration: none;
        }

        .download-btn:hover {
            background-color: #0056b3;
        }

        .unfollow {
            border: 1px solid black;
            display: inline-block;
            border-radius: 4px;
            padding: 5px 10px;
            cursor: pointer;


        }

    </style>

</head>
<body>

<nav class="border-b px-4 py-2 bg-white">
    <div class="flex flex-wrap items-center justify-between md:justify-around">
        <img class="h-10"
             src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/150px-Instagram_logo.svg.png"
             alt="instagram">
        <#if user??>
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

<main class="bg-gray-100 bg-opacity-25">

    <div class="lg:w-8/12 lg:mx-auto mb-8">

        <header class="flex flex-wrap items-center p-4 md:py-8">

            <div class="md:w-3/12 md:ml-16">
                <!-- profile image -->
                <img class="w-20 h-20 md:w-40 md:h-40 object-cover rounded-full
                       border-2 border-pink-600 p-1" src="/posts/photo/${account.id}">
            </div>


            <div class="w-8/12 md:w-7/12 ml-4">
                <div class="md:flex md:flex-wrap md:items-center mb-4">
                    <h2 class="text-3xl inline-block font-light md:mr-2 mb-2 sm:mb-0">
                        ${account.accountName}
                    </h2>

                    <!-- badge -->
                    <span class="inline-block fas fa-certificate fa-lg text-blue-500
                                 relative mr-6  text-xl transform -translate-y-2" aria-hidden="true">
              <i class="fas fa-check text-white text-xs absolute inset-x-0
                                 ml-1 mt-px"></i>
            </span>

                    <!-- edit button -->
                    <#if user??>
                        <#if isFollower>
                            <button type="button" id="un"
                                    class="unfollow">Unfollow
                            </button>
                        <#else>
                            <button type="button" id="followBtn"
                                    class="delete-btn download-btn">Follow
                            </button>
                        </#if>
                    </#if>
                </div>

                <!-- post, following, followers list for medium screens -->
                <ul class="hidden md:flex space-x-8 mb-4">
                    <li>
                        <span class="font-semibold">6</span>
                        posts
                    </li>

                    <li>
                        <span class="font-semibold">50.5k</span>
                        followers
                    </li>
                    <li>
                        <span class="font-semibold">10</span>
                        following
                    </li>
                </ul>

                <!-- user meta form medium screens -->
                <div class="hidden md:block">
                    <h1 class="font-semibold">${account.fullName}</h1>
                    <p>ByteWebster is a web development and coding blog website. Where we provide professional web
                        projects🌍</p>
                    <span><strong>${account.email}</strong></span>
                </div>

            </div>

            <!-- user meta form small screens -->
            <div class="md:hidden text-sm my-2">
                <h1 class="font-semibold">${account.fullName}</h1>
                <span class="bioclass">Internet company</span>
                <p>ByteWebster is a web development and coding blog website. Where we provide professional web
                    projects🌍</p>
                <span><strong>${account.email}</strong></span>
            </div>

        </header>

        <!-- posts -->
        <div class="px-px md:px-3">

            <!-- user following for mobile only -->
            <ul class="flex md:hidden justify-around space-x-8 border-t
                  text-center p-2 text-gray-600 leading-snug text-sm">
                <li>
                    <span class="font-semibold text-gray-800 block">6</span>
                    posts
                </li>

                <li>
                    <span class="font-semibold text-gray-800 block">50.5k</span>
                    followers
                </li>
                <li>
                    <span class="font-semibold text-gray-800 block">10</span>
                    following
                </li>
            </ul>
            <br>
            <br>
            <!-- insta freatures -->
            <ul class="flex items-center justify-around md:justify-center space-x-12
                      uppercase tracking-widest font-semibold text-xs text-gray-600
                      border-t">
                <!-- posts tab is active -->
                <li class="md:border-t md:border-gray-700 md:-mt-px md:text-gray-700">
                    <a class="inline-block p-3" href="#">
                        <i class="fas fa-th-large text-xl md:text-xs"></i>
                        <span class="hidden md:inline">post</span>
                    </a>
                </li>
            </ul>

            <!-- flexbox grid -->
            <div class="flex flex-wrap -mx-px md:-mx-3">

                <!-- column -->
                <#list account.images as image>
                    <div class="w-1/3 p-px md:px-3">
                        <!-- post 1-->
                        <a href="#">
                            <article class="post bg-gray-100 text-white relative pb-full md:mb-6">
                                <!-- post images-->
                                <img id="im" class="w-full h-full absolute left-0 top-0 object-cover"
                                     src="/posts/${image.id}/${account.id}"
                                     alt="image">

                                <i class="fas fa-square absolute right-0 top-0 m-1"></i>
                                <!-- overlay-->
                                <div class="overlay bg-gray-800 bg-opacity-25 w-full h-full absolute
                                                  left-0 top-0 hidden">
                                    <div class="flex justify-center items-center
                                                      space-x-4 h-full">
                                    <span class="p-2">
                                      <i class="fas fa-heart"></i>
                                      412K
                                    </span>

                                        <span class="p-2">
                                      <i class="fas fa-comment"></i>
                                      2,909
                                    </span>
                                    </div>
                                </div>

                            </article>
                        </a>
                    </div>
                </#list>

            </div>
        </div>
    </div>
</main>

<nav class="bg-white border-t fixed bottom-0 w-full">
    <ul class="flex justify-around py-2">
        <li class="flex-1 text-center">
            <a href="/" class="text-gray-600 hover:text-blue-500">
                <i class="fas fa-home text-xl"></i>
            </a>
        </li>
        <li class="flex-1 text-center">
            <a href="/users" class="text-gray-600 hover:text-blue-500">
                <i class="fas fa-search text-xl"></i>
            </a>
        </li>
        <li class="flex-1 text-center">
            <a href="/images" class="text-gray-600 hover:text-blue-500">
                <i class="far fa-plus-square text-xl"></i>
            </a>
        </li>
        <li class="flex-1 text-center">
            <a href="#" id="act" class="text-gray-600 hover:text-blue-500">
                <i class="far fa-user text-xl"></i>
            </a>
        </li>
    </ul>

</nav>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const followButton = document.getElementById('followBtn');
        const unfollowButton = document.getElementById('un')

        if (followButton) {
            followButton.addEventListener("click", function () {

                fetch(`/follow/` + ${account.id}, {
                    method: 'GET'
                })
                    .then(response => {
                        if (response.ok) {
                            location.reload();
                        } else {
                            console.error('Error following:', response.status);
                        }
                    })
                    .catch(error => {
                        console.error('Error following:', error);
                    });

            });
        }

        if (unfollowButton) {
            unfollowButton.addEventListener("click", function () {
                console.log("unfollow button is clicked!")
                fetch(`/follow/` + ${account.id}, {
                    method: 'DELETE'
                })
                    .then(response => {
                        if (response.ok) {
                            location.reload();
                        } else {
                            console.error('Error unfollowing', response.status);
                        }
                    })
                    .catch(error => {
                        console.error('Error unfollowing:', error);
                    });

            });
        }

        document.getElementById('logout').addEventListener('click', () => {
            localStorage.removeItem('user')
        })
    });

</script>
</body>
</html>
