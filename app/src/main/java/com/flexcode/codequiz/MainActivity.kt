package com.flexcode.codequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.flexcode.codequiz.databinding.ActivityMainBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mInterstitialAd: InterstitialAd? = null
    private var TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadInterAd()
        loadBannerAd()

        binding.btnStart.setOnClickListener {
            if (binding.etName.text.toString().trim().isEmpty()) {
                Toast.makeText(
                    this, getString(R.string.enter_name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                startActivity(intent)
                showInterAd()
                //finish()
            }
        }
    }

    private fun showInterAd() {
        if (mInterstitialAd!= null){
            mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                    startActivity(intent)
                    finish()
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                }
            }
            mInterstitialAd?.show(this)

        }else{
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
            startActivity(intent)
            finish()
        }
    }

    private fun loadBannerAd() {
        //ads
        MobileAds.initialize(this@MainActivity)
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        //methods
        binding.adView.adListener = object: AdListener() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Toast.makeText(
                    this@MainActivity,
                    "Ad Load Fail", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun loadInterAd() {
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-5201606964951300/5988467582", adRequest,
            object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
    }
}