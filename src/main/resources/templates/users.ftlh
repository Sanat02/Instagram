<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Profile</title>

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

        .setPhoto {
            margin-top: 5px;
            margin-left: 46px;
        }

        /* New styles for the form container */
        .form-container {
            margin-left: 450px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }

        .form-input {
            width: 100%;
            max-width: 400px;
            padding: 10px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-textarea {
            width: 100%;
            max-width: 400px;
            padding: 10px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: vertical;
        }

        .form-button {
            background-color: dodgerblue;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .user-list tbody td > img {
            position: relative;
            max-width: 50px;
            float: left;
            margin-right: 15px;
        }

        .user-list tbody td .user-link {
            display: block;
            font-size: 1.25em;
            padding-top: 3px;
            margin-left: 60px;
        }

        .user-list tbody td .user-subhead {
            font-size: 0.875em;
            font-style: italic;
        }

        /* TABLES */
        .table {
            border-collapse: separate;
        }

        .table-hover > tbody > tr:hover > td,
        .table-hover > tbody > tr:hover > th {
            background-color: #eee;
        }

        .table thead > tr > th {
            border-bottom: 1px solid #C2C2C2;
            padding-bottom: 0;
        }

        .table tbody > tr > td {
            font-size: 0.875em;
            background: #f5f5f5;
            border-top: 10px solid #fff;
            vertical-align: middle;
            padding: 12px 8px;
        }

        .table tbody > tr > td:first-child,
        .table thead > tr > th:first-child {
            padding-left: 20px;
        }

        .table thead > tr > th span {
            border-bottom: 2px solid #C2C2C2;
            display: inline-block;
            padding: 0 5px;
            padding-bottom: 5px;
            font-weight: normal;
        }

        .table thead > tr > th > a span {
            color: #344644;
        }

        .table thead > tr > th > a span:after {
            content: "\f0dc";
            font-family: FontAwesome;
            font-style: normal;
            font-weight: normal;
            text-decoration: inherit;
            margin-left: 5px;
            font-size: 0.75em;
        }

        .table thead > tr > th > a.asc span:after {
            content: "\f0dd";
        }

        .table thead > tr > th > a.desc span:after {
            content: "\f0de";
        }

        .table thead > tr > th > a:hover span {
            text-decoration: none;
            color: #2bb6a3;
            border-color: #2bb6a3;
        }

        .table.table-hover tbody > tr > td {
            -webkit-transition: background-color 0.15s ease-in-out 0s;
            transition: background-color 0.15s ease-in-out 0s;
        }

        .table tbody tr td .call-type {
            display: block;
            font-size: 0.75em;
            text-align: center;
        }

        .table tbody tr td .first-line {
            line-height: 1.5;
            font-weight: 400;
            font-size: 1.125em;
        }

        .table tbody tr td .first-line span {
            font-size: 0.875em;
            color: #969696;
            font-weight: 300;
        }

        .table tbody tr td .second-line {
            font-size: 0.875em;
            line-height: 1.2;
        }

        .table a.table-link {
            margin: 0 5px;
            font-size: 1.125em;
        }

        .table a.table-link:hover {
            text-decoration: none;
            color: #2aa493;
        }

        .table a.table-link.danger {
            color: #fe635f;
        }

        .table a.table-link.danger:hover {
            color: #dd504c;
        }

        .table-products tbody > tr > td {
            background: none;
            border: none;
            border-bottom: 1px solid #ebebeb;
            -webkit-transition: background-color 0.15s ease-in-out 0s;
            transition: background-color 0.15s ease-in-out 0s;
            position: relative;
        }

        .table-products tbody > tr:hover > td {
            text-decoration: none;
            background-color: #f6f6f6;
        }

        .table-products .name {
            display: block;
            font-weight: 600;
            padding-bottom: 7px;
        }

        .table-products .price {
            display: block;
            text-decoration: none;
            width: 50%;
            float: left;
            font-size: 0.875em;
        }

        .table-products .price > i {
            color: #8dc859;
        }

        .table-products .warranty {
            display: block;
            text-decoration: none;
            width: 50%;
            float: left;
            font-size: 0.875em;
        }

        .table-products .warranty > i {
            color: #f1c40f;
        }

        .table tbody > tr.table-line-fb > td {
            background-color: #9daccb;
            color: #262525;
        }

        .table tbody > tr.table-line-twitter > td {
            background-color: #9fccff;
            color: #262525;
        }

        .table tbody > tr.table-line-plus > td {
            background-color: #eea59c;
            color: #262525;
        }

        .table-stats .status-social-icon {
            font-size: 1.9em;
            vertical-align: bottom;
        }

        .table-stats .table-line-fb .status-social-icon {
            color: #556484;
        }

        .table-stats .table-line-twitter .status-social-icon {
            color: #5885b8;
        }

        .table-stats .table-line-plus .status-social-icon {
            color: #a75d54;
        }

        .container {
            margin-top: 35px;
            margin-left: 700px;
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
                <a class="inline-block bg-blue-500 px-2 py-1 text-white font-semibold
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

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box clearfix">
                <div class="table-responsive">
                    <table class="table user-list">
                        <tbody>
                        <#list users as user>

                            <tr>
                                <td>

                                    <a href="#">${user.accountName}</a>

                                </td>
                                <#if account?? && account.id==user.id>
                                    <td style="width: 20%;">
                                        <a href="/profile" class="table-link">
                                            <button>your profile</button>
                                        </a>
                                    </td>
                                <#else>
                                    <td style="width: 20%;">
                                        <a href="/users/${user.id}" class="table-link">
                                            <button>see profile</button>
                                        </a>
                                    </td>
                                </#if>
                            </tr>

                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<nav class="bg-white border-t fixed bottom-0 w-full">

    <ul class="flex justify-around py-2">

        <li class="flex-1 text-center">
            <a href="/" class="text-gray-600 hover:text-blue-500">
                <i class="fas fa-home text-xl"></i>
            </a>
        </li>
        <li class="flex-1 text-center">
            <a href="#" id="act" class="text-gray-600 hover:text-blue-500">
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
</body>
</html>
