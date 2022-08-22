<div id="login-box" class="login-box">
 <h1>Sign In</h1>
 <h2>Welcome Back!</h2>
 <h3>To keep connected with us. Please login with personal info.</h3>
 <div>
   <div class="user-box">
     <input type="text" name="user" id ="user" required>
     <label>User Name</label>
   </div>
   <div class="user-box">
     <input type="password" name="pass" id="pass" required>
     <label>Password</label>
   </div>
   <div class="check-box">
     <input type="checkbox" id="cb" onclick="writeCookie()">
     <label for="cb">Remember me</label>
   </div>
   <input id="sm" type="submit" value="Login" onclick="send_login()">
 </div>
 <div id="fp">
     <a href="#">Forgot password?</a>
     <button onclick="getLogin()">Cancel</button>
   </div>
</div>