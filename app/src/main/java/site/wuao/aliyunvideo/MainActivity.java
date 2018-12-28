package site.wuao.aliyunvideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aliyun.apsaravideo.recorder.AliyunVideoRecorder;
import com.aliyun.svideo.sdk.external.struct.common.VideoDisplayMode;
import com.aliyun.svideo.sdk.external.struct.common.VideoQuality;
import com.aliyun.svideo.sdk.external.struct.encoder.VideoCodecs;
import com.aliyun.svideo.sdk.external.struct.recorder.CameraType;
import com.aliyun.svideo.sdk.external.struct.recorder.FlashType;
import com.aliyun.svideo.sdk.external.struct.snap.AliyunSnapVideoParam;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AliyunSnapVideoParam recordParam = new AliyunSnapVideoParam.Builder()
                // 分辨率模式540p
                .setResolutionMode(AliyunSnapVideoParam.RESOLUTION_540P)
                // 视频比例3:4
                .setRatioMode(AliyunSnapVideoParam.RATIO_MODE_3_4)
                // 录制模式
                .setRecordMode(AliyunSnapVideoParam.RECORD_MODE_AUTO)
                // 滤镜
                // .setFilterList(effectDirs)
                // 美颜级别
                .setBeautyLevel(80)
                // 美颜
                .setBeautyStatus(true)
                // 前置摄像头
                .setCameraType(CameraType.FRONT)
                .setFlashType(FlashType.ON)
                // 是否需要剪裁
                .setNeedClip(true)
                // 最大时长5分钟
                .setMaxDuration(5 * 60 * 1000)
                // 最小时长2秒
                .setMinDuration(2 * 1000)
                // 视频质量
                .setVideoQuality(VideoQuality.HD)
                .setGop(5)
                .setVideoCodec(VideoCodecs.H264_HARDWARE)

                /**
                 * 裁剪参数
                 */
                .setFrameRate(25)
                .setCropMode(VideoDisplayMode.FILL)
                // 显示分类SORT_MODE_VIDEO视频;SORT_MODE_PHOTO图片;SORT_MODE_MERGE图片和视频
                .setSortMode(AliyunSnapVideoParam.SORT_MODE_VIDEO)
                .build();
        AliyunVideoRecorder.startRecordForResult(this, 100, recordParam);
    }
}
