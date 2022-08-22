<div id="register" class="login-box">
 <h1>Register</h1>
 <h2>Welcome to my Website</h2>
 <h3>Connect with us and enjoy my service</h3>
 <div>
   <div class="user-box">
     <input type="text" name="user" id ="username" required>
     <label>User Name</label>
   </div>
   <div class="user-box">
     <input type="password" name="pass" id="password" required>
     <label>Password</label>
   </div>
   <div class="user-box">
     <input type="password" name="re-pass" id="re-password" required>
     <label>Repeat Password</label>
   </div>
   <input id="sm" type="submit" value="Submit" onclick="send_register()">
 </div>
 <div id="fp">
     <button onclick="getRegister()">Cancel</button>
   </div>
</div>