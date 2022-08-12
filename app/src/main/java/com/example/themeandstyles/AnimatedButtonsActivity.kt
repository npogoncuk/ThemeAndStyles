package com.example.themeandstyles

import android.animation.AnimatorInflater.loadAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.animation.CycleInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.themeandstyles.databinding.ActivityAnimatedButtonsBinding


class AnimatedButtonsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimatedButtonsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimatedButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            valueAnimatorButton.setOnClickListener {
                with(
                    loadAnimator(
                        this@AnimatedButtonsActivity,
                        R.animator.disappearance_animation
                    ) as ValueAnimator
                ) {
                    addUpdateListener {
                        binding.valueAnimatorButton.alpha = it?.animatedValue as Float
                    }
                    start()
                }

            }

            objectAnimatorButton.setOnClickListener {
                with(loadAnimator(this@AnimatedButtonsActivity, R.animator.rotation_animation)) {
                    setTarget(it)
                    start()
                }
            }

            viewPropertyAnimatorButton.setOnClickListener {
                it.animate()
                    .alpha(0f)
                    .rotation(360f)
                    .scaleX(2f)
                    .scaleY(2f)
                    .setDuration(2000L)
                    .setInterpolator(object : CycleInterpolator(.5f){})
                    .start()
            }

            transitionButton.setOnClickListener {
                val intent = Intent(this@AnimatedButtonsActivity, TransitionActivity::class.java)
                val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this@AnimatedButtonsActivity, it, "transitionButton")
                startActivity(intent, activityOptions.toBundle())
            }
        }



    }
}