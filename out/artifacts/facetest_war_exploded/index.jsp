<%--
  Created by IntelliJ IDEA.
  User: 陈忠阔
  Date: 2019/4/12
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div id="contentHolder">
    <video id="video" width="320" height="320" autoplay></video>
    <button id="camera">拍照</button>
    <button id="send">登陆</button>
    <canvas id="canvas" width="320" height="320">
    </canvas>
  </div>
  </body>
  <script src="lib/jquery-1.8.3.js"></script>
  <script type="text/javascript">
      var video = document.getElementById('video');
      var track;
      var Camera= document.getElementById('camera');
      var bases;
      window.addEventListener("DOMContentLoaded", function(){
          navigator.getUserMedia = navigator.getUserMedia ||	navigator.webkitGetUserMedia ||	navigator.mozGetUserMedia;
          if (navigator.getUserMedia) {
              navigator.getUserMedia({video:true},
                  function(stream) {
                      track = stream.getTracks()[0];  // 通过这个关闭摄像头
                      video.src = window.URL.createObjectURL(stream);
                      video.onloadedmetadata = function(e) {
                          video.play();
                      };
                  },
                  function(err) {
                      alert(err.name);
                  }
              );
          }


      });
      Camera.onclick = function(){
          var canvas = document.getElementById('canvas');
          var context2D = canvas.getContext("2d");
          context2D.fillStyle = "#ffffff";
          context2D.fillRect(0, 0, 320, 320);
          context2D.drawImage(video, 0, 0, 320, 320);
          var image_code =canvas.toDataURL("image/png");//要传给后台的base64
          console.log(image_code)
          $('#send').click(function(){
              var _this =this;
              $.ajax({
                  type: "POST",
                  url: "http://localhost:8999/jsp/getBaseStr",
                  data: {
                      baseStr:image_code,
                  },
                  dataType: "json",
                  success: function(data){
                      // $('#resText').empty();   //清空resText里面的所有内容
                      // var html = '';
                      // $.each(data, function(commentIndex, comment){
                      //     html += '<div class="comment"><h6>' + comment['username']
                      //         + ':</h6><p class="para"' + comment['content']
                      //         + '</p></div>';
                      // });
                      // $('#resText').html(html);
                      alert(data);

                  }
              });
          });
          if (null != track) {
              track.stop();//关闭摄像头
          }
      };

  </script>
</html>
