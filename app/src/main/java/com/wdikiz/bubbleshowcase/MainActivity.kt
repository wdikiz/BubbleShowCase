package com.wdikiz.bubbleshowcase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.wdikiz.bubbleshowcase.databinding.ActivityMainBinding // Import your binding class

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.buttonSimpleShowCase.setOnClickListener { getSimpleShowCaseBuilder().show() }
        binding.buttonColorShowCase.setOnClickListener { getCustomColorShowCaseBuilder().show() }
        binding.buttonTextSizeShowCase.setOnClickListener { getTextSizeShowCaseBuilder().show() }
        binding.buttonArrowLeftShowCase.setOnClickListener { getArrowLeftShowCaseBuilder().show() }
        binding.buttonArrowRightShowCase.setOnClickListener { getArrowRightShowCaseBuilder().show() }
        binding.buttonEventListener.setOnClickListener { getListenerShowCaseBuilder().show() }
        binding.buttonSequence.setOnClickListener { getSequence().show() }
    }

    private fun getSimpleShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Welcome!!!")
            .description("This is a simple BubbleShowCase with default values.")
            .targetView(binding.buttonSimpleShowCase)
    }

    private fun getCustomColorShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Custom your bubble style!")
            .description("It is possible to change the text color, background ... and you can even add an image into your bubble.")
            .backgroundColor(ContextCompat.getColor(this, R.color.colorBlueGray))
            .backgroundColor(ContextCompat.getColor(this, R.color.colorBlueGray))
            .image(ContextCompat.getDrawable(this, R.drawable.ic_color)!!)
            .closeActionImage(ContextCompat.getDrawable(this, R.drawable.ic_close_black)!!)
            .textColor(ContextCompat.getColor(this, R.color.colorBlack))
            .targetView(binding.buttonColorShowCase)
    }

    private fun getTextSizeShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Change text sizes!")
            .description("You can also choose the best text size for you.")
            .backgroundColor(ContextCompat.getColor(this, R.color.colorTeal))
            .image(ContextCompat.getDrawable(this, R.drawable.ic_format_size)!!)
            .titleTextSize(18)
            .descriptionTextSize(16)
            .closeActionImage(null)
            .targetView(binding.buttonTextSizeShowCase)
    }

    private fun getArrowLeftShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Force the position of the bubble!")
            .description("You only have to specify in which side you want the arrow, and the bubble will be located depending on it.")
            .arrowPosition(BubbleShowCase.ArrowPosition.LEFT)
            .backgroundColor(ContextCompat.getColor(this, R.color.colorRed))
            .targetView(binding.buttonArrowLeftShowCase)
    }

    private fun getArrowRightShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Arrow set on right side this time :)")
            .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)
            .backgroundColor(ContextCompat.getColor(this, R.color.colorPink))
            .targetView(binding.buttonArrowRightShowCase)
    }

    private fun getListenerShowCaseBuilder(): BubbleShowCaseBuilder {
        return BubbleShowCaseBuilder(this)
            .title("Listen user actions!")
            .description("You can detect when the user interacts with the different view elements to act consequently.")
            .backgroundColor(ContextCompat.getColor(this, R.color.colorOrange))
            .image(ContextCompat.getDrawable(this, R.drawable.ic_sentiment_satisfied)!!)
            .listener(object : BubbleShowCaseListener {
                override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                }

                override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                }

                override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                    Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                }
            })
            .targetView(binding.buttonEventListener)
    }

    private fun getSequence(): BubbleShowCaseSequence {
        return BubbleShowCaseSequence().addShowCases(listOf(
            getSimpleShowCaseBuilder(),
            getCustomColorShowCaseBuilder(),
            getTextSizeShowCaseBuilder(),
            getArrowLeftShowCaseBuilder(),
            getArrowRightShowCaseBuilder(),
            getListenerShowCaseBuilder()
        ))
    }
}
