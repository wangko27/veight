$(document).ready(function(){
  var myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"
  }, [
    {
      title:"Busted Chump林俊杰 - 曹操",
      artist:"ADG3",
      mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"C林俊杰 - 曹操",
      artist:"3studios",
      mp3: "js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"Cloudless Days",
      artist:"林俊杰 - 曹操",
      mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"Core Issues",
      artist:"林俊杰 - 曹操",
      mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"Cryptic Psyche",
      artist:"ADG3",
       mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"林俊杰 - 曹操",
      artist:"Studios",
       mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    },
    {
      title:"林俊杰 - 曹操",
      artist:"ADG",
      mp3: "template/home/js/jPlayer/mp3/林俊杰 - 曹操.mp3",
      poster: "template/home/images/m0.jpg"
    }
  ], {
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: true
    },
	timeupdate: function(event) {
		 if(event.jPlayer.status.currentTime==0){
			time = "";
		 }else {
			time = event.jPlayer.status.currentTime;
		 }
	},
	play: function(event) {
		//初始化歌词信息(传入歌词文件文本)
		$.lrc.init($('#lrc_content').val());
		//点击开始方法调用lrc.start歌词方法 返回时间time
		if($('#lrc_content').val()!==""){
			$.lrc.start(function(){
				return time;
			});
		}else{
		 $(".content").html("没有字幕");
		}
	},
    swfPath: "template/home/js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false
  });
  
  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').addClass('animate');
  });

  $(document).on('click', '.jp-play-me', function(e){
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

    $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if( !$this.hasClass('active') ){
      myPlaylist.pause();
    }else{
      var i = Math.floor(Math.random() * (1 + 7 - 1));
      myPlaylist.play(i);
    }
    
  });

  // video
  $("#jplayer_1").jPlayer({
    ready: function () {
	 
      $(this).jPlayer("setMedia", {
        title: "Big Buck Bunny",
		mp3: "js/jPlayer/mp3/林俊杰 - 曹操.mp3",
        poster: "images/m41.jpg"
      });
    },
    swfPath: "js",
    supplied: "webmv, ogv, m4v",
    size: {
      width: "100%",
      height: "auto",
      cssClass: "jp-video-360p"
    },
    globalVolume: true,
    smoothPlayBar: true,
    keyEnabled: true
  });

});