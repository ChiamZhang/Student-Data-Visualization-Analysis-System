$('#chooseImage').on('change', function () {
    var filePath = $(this).val();         //获取到input的value，里面是文件的路径
    console.log(filePath);
    var fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
    // 检查是否是图片
    if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
        error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
        return;
    }
    var src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
    $('#cropedBigImg').attr('src', src);
});