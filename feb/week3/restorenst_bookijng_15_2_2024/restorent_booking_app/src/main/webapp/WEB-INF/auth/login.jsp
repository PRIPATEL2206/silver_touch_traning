<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
</head>

<body class="antialiased border-top-wide border-primary d-flex flex-column">
    <div class="page page-center mt-6">
        <div class="container-tight py-4">
            <div class="text-center mb-6">
                <a href="."><img src="https://tabler.github.io/tabler/demo/brand/tabler.svg" alt="" height="36"></a>
            </div>
            <form class="card card-md" id="loginForm" action="/login" method="post">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">Login to your account</h2>
                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username"
                            placeholder="Enter your username" required>
                    </div>
                    <div class="mb-2">
                        <label class="form-label">
                            Password
                            <span class="form-label-description">
                                <a href="./forgot-password.html">I forgot my password</a>
                            </span>
                        </label>
                        <div class="input-group input-group-flat">
                            <input type="password" class="form-control" id="password" name="password"
                                placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-footer">
                        <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                    </div>
                </div>
            </form>
            <div class="text-center text-muted mt-3">
                Register as a restaurant <a href="/registerRestorent" tabindex="-1">Creste One</a>
            </div>
        </div>
    </div>

</body>

</html>