package own.fuckingpermissions

/*
*
* Fucking Permissions.....
*
* Google is cocksucker for making this shit compicated
*
* IT do not work in Android 13 on my new pixel phone.
*
* */


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Environment
import android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import own.fuckingpermissions.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.charset.Charset
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {



    ///val FilesPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/FuckYou/"
    ///val PalFilesPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/FuckYou/pal/"

/*

We have to fucking switch to one of those dirs..
Thank you to stupid fuckers at google.
I totally fucking hate you!

public static String DIRECTORY_MUSIC = "Music";
public static String DIRECTORY_ALARMS = "Alarms";
public static String DIRECTORY_NOTIFICATIONS = "Notifications";
public static String DIRECTORY_PICTURES = "Pictures";
public static String DIRECTORY_MOVIES = "Movies";
public static String DIRECTORY_DOWNLOADS = "Download";
public static String DIRECTORY_DCIM = "DCIM";
public static String DIRECTORY_DOCUMENTS = "Documents";

Hope this damned app still work on OLD Shitty phones......

//File directory = cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
//File file = new File(directory, "something" + ".MP3");

*/


    val FilesPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/FuckYou/"
    val PalFilesPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/FuckYou/pal/"


    val LocationPerms = 5001
    val BackgroundLocationPerms = 5002
    val StoragePerms = 5003

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        //asking for stupid fucking permissions.....
        showLocationPermsDialogue()

        runme()

        val text = findViewById<TextView>(R.id.text)
        text.setText("Fuck you android permissions!!!!!!   complicated shit!")



        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun showLocationPermsDialogue() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.i("fuck-you", "Location Perms are already granted :)")
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LocationPerms)
                Log.i("fuck-you", "Asking for Location Perms")
            }
        }
    }


    private fun showBGLocationPermsDialogue() {
        if(SDK_INT >= 29) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.i("fuck-you", "Background Location Perms are already granted :)")
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), BackgroundLocationPerms)
                Log.i("fuck-you", "Asking for Background Location Perms")
            }
        }
        }
    }

    private fun showFileWritePermsDialogue() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.i("fuck-you", "Storage Perms are already granted :)")
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), StoragePerms)
                Log.i("fuck-you", "Asking for Storage Perms")
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            StoragePerms -> {
                showBGLocationPermsDialogue()
            }
        }
    }


    /*
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            StoragePerms -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //ask for bg location perms...
                showBGLocationPermsDialogue()
            } else {
                // Permission Denied
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
*/

    fun runme() {

        Log.d("fuck-you", "runme()")

        //FUCK YOU GOOGLE!!!!!!  They kept changing their code to "secure" the storage   FUCK YOU
        //my ass will be at your new HQ offices and chewing you out for what you did to me.  I fucking hate companies that censor.
        //I will make you pay my fucking income!!!!  FUCK YOU!!!!
        //Google company Execs need metal pipes in their asses for breaking their promoise not to censor!!!!!
        //file access permission functions moved to WX.kt
        if(SDK_INT >= 30) {
            Log.d("fuck-you", "SDK is 30 or above")
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            {
                Log.i("fuck-you", "Asking for Storage Perms for older android")
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), StoragePerms)
            }
        }



        checkfiles(R.drawable.headingbug, "headingbug.png")
        checkfiles(R.drawable.star_cyan, "star_cyan.png")
        checkfiles(R.drawable.location, "location.png")
        checkfiles(R.drawable.tvs, "tvs.png")
        checkfiles(R.drawable.userpoint, "userpoint.png")
        checkfiles(R.drawable.hailunknown, "hailunknown.png")
        checkfiles(R.drawable.hail05, "hail05.png")
        checkfiles(R.drawable.hail0, "hail0.png")
        checkfiles(R.drawable.hail1, "hail1.png")
        checkfiles(R.drawable.hail2, "hail2.png")
        checkfiles(R.drawable.hail3, "hail3.png")
        checkfiles(R.drawable.hail4, "hail4.png")
        checkfiles(R.drawable.hailbig, "hailbig.png")

        checkpalfiles(R.raw.colormap19, "colormap19.txt")
        checkpalfiles(R.raw.colormap30, "colormap30.txt")
        checkpalfiles(R.raw.colormap56, "colormap56.txt")
        checkpalfiles(R.raw.colormap134cod, "colormap134cod.txt")
        checkpalfiles(R.raw.colormap135cod, "colormap135cod.txt")
        checkpalfiles(R.raw.colormap159cod, "colormap159cod.txt")
        checkpalfiles(R.raw.colormap161cod, "colormap161cod.txt")
        checkpalfiles(R.raw.colormap163cod, "colormap163cod.txt")
        checkpalfiles(R.raw.colormap165cod, "colormap165cod.txt")
        checkpalfiles(R.raw.colormap172cod, "colormap172cod.txt")
        checkpalfiles(R.raw.colormapbvaf, "colormapbvaf.txt")
        checkpalfiles(R.raw.colormapbvcod, "colormapbvcod.txt")
        checkpalfiles(R.raw.colormapbveak, "colormapbveak.txt")
        checkpalfiles(R.raw.colormaprefaf, "colormaprefaf.txt")
        checkpalfiles(R.raw.colormaprefcode, "colormaprefcode.txt")
        checkpalfiles(R.raw.colormaprefcodenh, "colormaprefcodenh.txt")
        checkpalfiles(R.raw.colormaprefdkenh, "colormaprefdkenh.txt")
        checkpalfiles(R.raw.colormaprefeak, "colormaprefeak.txt")
        checkpalfiles(R.raw.colormaprefmenh, "colormaprefmenh.txt")
        checkpalfiles(R.raw.colormaprefnssl, "colormaprefnssl.txt")
        checkpalfiles(R.raw.colormaprefnwsd, "colormaprefnwsd.txt")
        //elys custom color tables
        checkpalfiles(R.raw.colormapownref, "colormapownref.txt")
        checkpalfiles(R.raw.colormapownvel, "colormapownvel.txt")
        checkpalfiles(R.raw.colormapownenhvel, "colormapownenhvel.txt")
        //need to run it again
        //ColorPalettes.initialize(applicationContext)

        //make to download new conus everytime the app start...
        //Log.d("fuck-you", "downloading conus on start....")
        //UtilityConusRadar.getConusImage()

        //start service for Spotter Network Location Auto Reporting
        //if (RadarPreferences.sn_locationreport) {
        //    applicationContext.startService(Intent(applicationContext, SpotterNetworkPositionReportService::class.java))
        //}

        /*
        if (Utility.readPref(this, "LAUNCH_TO_RADAR", "false") == "false") {
            Route(this, WX::class.java)
        } else {
            val wfo = Location.wfo
            val state = UtilityLocation.getWfoSiteName(wfo).split(",")[0]
            val radarSite = Location.getRid(this, Location.currentLocationStr)
            Route.radar(this, arrayOf(radarSite, state))
        }

         */

    }


    fun checkfiles(drawable: Int, filename: String) {
        Log.d("fuck-you", "running files check on " + FilesPath)
        val dir = File(FilesPath)
        if (!dir.exists()) {
            Log.d("fuck-you", "making dir")
            dir.mkdirs()
        }

        var file = File(FilesPath + filename)
        var fileExists = file.exists()
        if(!fileExists)
        {
            //need to copy files!
            Log.d("fuck-you", filename + " does not exist.")
            var bitmap: Bitmap = BitmapFactory.decodeResource(resources, drawable)
            saveBitmapToFile(filename, bitmap)

        } else {
            Log.d("fuck-you", filename + " are there!")
        }
    }

    fun saveBitmapToFile(fileName: String, bm: Bitmap) {
        val file = File(FilesPath, fileName)
        try {
            val out = FileOutputStream(file)
            bm.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
            out.close()
            Log.d("fuck-you", fileName + " copied!")
        } catch (e: Exception) {
            Log.d("fuck-you", "checkfiles Exception!")
            e.printStackTrace()
        }

    }


    //check colortable files and copy if any missing//
    fun checkpalfiles(resourceId: Int, filename: String) {
        Log.d("fuck-you", "running files check on " + PalFilesPath)
        val dir = File(PalFilesPath)
        if (!dir.exists()) {
            Log.d("fuck-you", "making dir")
            dir.mkdirs()
        }

        var file = File(PalFilesPath + filename)
        var fileExists = file.exists()
        if(!fileExists)
        {
            //need to copy files!
            Log.d("fuck-you", filename + " does not exist.")
            saveRawToFile(filename, resourceId)
        } else {
            Log.d("fuck-you", filename + " are there!")
        }
    }

    private fun saveRawToFile(fileName: String, resourceId: Int) {
        val dir = PalFilesPath
        var ins: InputStream = resources.openRawResource(resourceId)
        var content = ins.readBytes().toString(Charset.defaultCharset())
        File("$dir/$fileName").printWriter().use {
            it.println(content)
        }
    }



}















