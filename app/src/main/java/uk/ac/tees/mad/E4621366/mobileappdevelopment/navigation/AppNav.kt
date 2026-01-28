package uk.ac.tees.mad.E4621366.mobileappdevelopment.navigation


import android.app.Activity
import android.app.Application
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import uk.ac.tees.mad.E4621366.mobileappdevelopment.screen.DashboardScreen
import uk.ac.tees.mad.E4621366.mobileappdevelopment.screen.SplashScreen
import uk.ac.tees.mad.E4621366.mobileappdevelopment.screen.auth.LoginScreen
import uk.ac.tees.mad.E4621366.mobileappdevelopment.screen.auth.RegisterScreen
import uk.ac.tees.mad.E4621366.mobileappdevelopment.viewmodel.AuthViewModel
import android.util.Log
import com.google.android.gms.common.api.ApiException
import uk.ac.tees.mad.E4621366.mobileappdevelopment.R
import androidx.compose.ui.res.stringResource


//@Composable
//fun AppNav() {
//    val navController = rememberNavController()
//    val context = LocalContext.current
//    val authVM: AuthViewModel = viewModel()
//
//    // Initialize Facebook SDK
////    FacebookSdk.sdkInitialize(context)
////    AppEventsLogger.activateApp(context.applicationContext as Application)
//
//    val callbackManager = CallbackManager.Factory.create()
//
//    // Google SignIn launcher
//    val googleSignInClient = GoogleSignIn.getClient(
//        context,
//        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(stringResource(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//    )
//
//    val googleSignInLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        try {
//            val account = task.getResult(ApiException::class.java)
//            val idToken = account.idToken
//            if (idToken != null) {
//                authVM.loginWithGoogle(idToken)
//            }
//        } catch (e: ApiException) {
//            Log.e("GoogleLogin", "Login failed", e)
//        }
//    }
//
//    // Facebook login lambda
////    val facebookLoginLauncher: () -> Unit = {
////        LoginManager.getInstance().logInWithReadPermissions(
////            context as Activity,
////            listOf("email", "public_profile")
////        )
////        LoginManager.getInstance().registerCallback(callbackManager,
////            object : FacebookCallback<LoginResult> {
////                override fun onSuccess(result: LoginResult) {
////                    val token = result.accessToken.token
////                    authVM.loginWithFacebook(token)
////                }
////
////                override fun onCancel() {}
////                override fun onError(error: FacebookException) {
////                    Log.e("FacebookLogin", "Login failed", error)
////                }
////            }
////        )
////    }
//}

//    NavHost(navController = navController, startDestination = "splash") {
//
//        composable("splash") {
//            SplashScreen(navController)
//        }
//
//        composable("login") {
//            LoginScreen(
//                navController = navController,
//                authVM = authVM,
//                onGoogleLogin = { googleSignInLauncher.launch(googleSignInClient.signInIntent) },
//                onFacebookLogin = { facebookLoginLauncher() }
//            )
//        }
//
//        composable("register") {
//            RegisterScreen(
//                navController = navController,
//                authVM = authVM
//            )
//        }
//
//        composable("dashboard") {
//            DashboardScreen()
//        }
//    }
//}

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { val authVM: AuthViewModel = viewModel();LoginScreen(navController,authVM) }
        composable("register") { val authVM: AuthViewModel = viewModel();RegisterScreen(navController,authVM) }
        composable("dashboard") {  val authVM: AuthViewModel = viewModel();DashboardScreen(navController,authVM) }
    }
}

