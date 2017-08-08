
package com.example.mark.switchbtn.view;

import android.os.Handler;
import android.os.Message;

/**
 * 动画控制类
 */
public class FrameAnimationController {
    private static final int MSG_ANIMATE = 1000;

    public static final int ANIMATION_FRAME_DURATION = 1000 / 60;

    private static final Handler mHandler = new AnimationHandler();

    private FrameAnimationController() {
        throw new UnsupportedOperationException();
    }

    public static void requestAnimationFrame(Runnable runnable) {
        Message message = new Message();
        message.what = MSG_ANIMATE;
        message.obj = runnable;
        mHandler.sendMessageDelayed(message, ANIMATION_FRAME_DURATION);
    }

    /**
     * 动画延时
     * 
     * @param runnable
     * @param delay 延时时间
     */
    public static void requestFrameDelay(Runnable runnable, long delay) {
        Message message = new Message();
        message.what = MSG_ANIMATE;
        message.obj = runnable;
        mHandler.sendMessageDelayed(message, delay);
    }

    /**
     * 执行动画
     */
    private static class AnimationHandler extends Handler {
        public void handleMessage(Message m) {
            switch (m.what) {
                case MSG_ANIMATE:
                    if (m.obj != null) {
                        ((Runnable) m.obj).run();
                    }
                    break;
            }
        }
    }
}
