//2016级生源省图谱
$(function () {
    var myChart = echarts.init(document.getElementById('ProvinceAtlasEcharts_2016'));
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '2016级省份生源图',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['2016级省份生源图']
        },
        visualMap: {
            type: 'piecewise',
            pieces: [
                { min: 1000, max: 1000000, label: '大于等于1000人', color: '#372a28' },
                { min: 500, max: 999, label: '500-999人', color: '#4e160f' },
                { min: 100, max: 499, label: '100-499人', color: '#974236' },
                { min: 10, max: 99, label: '10-99人', color: '#ee7263' },
                { min: 1, max: 9, label: '1-9人', color: '#f5bba7' },
            ],
            color: ['#E0022B', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        roamController: {
            show: true,
            left: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [
            {
                name: '人数',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    show: true,
                    color: 'rgb(249, 249, 249)'
                },
                data: []
            }
        ]
    };

    //使用指定的配置项和数据显示图表
    myChart.setOption(option);

    //获取数据
    function getData() {
        $.ajax({
            url: "/countByProvinceAndStu_grade",
            dataType: "json",
            success: function (data) {
                //  console.log(data.data)

                var newArr = [];
                //newArr的数据格式为：
                // [{
                //   name: '北京11',
                //   value: 212
                // }, {
                //   name: '天津',
                //   value: 60
                // }]

                //获取到各个省份的数据
                //  var province = res.areaTree[0].children;
                for (var i = 0; i < data.length; i++) {
                    if(data[i].stu_grade==2016){
                        var json = {
                            name: data[i].province,
                            value: data[i].quality
                        }
                        newArr.push(json)}
                }
                console.log(newArr)
                console.log(JSON.stringify(newArr))
                //使用指定的配置项和数据显示图表
                myChart.setOption({
                    series: [
                        {
                            name: '人数',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                show: true,
                                color: 'rgb(249, 249, 249)'
                            },
                            data: newArr
                        }
                    ]
                });

            }

        })
    }
    getData();

})
//2017级生源省图谱
$(function () {
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('ProvinceAtlasEcharts_2017'));
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '2016级省份生源图',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['2017级省份生源图']
        },
        visualMap: {
            type: 'piecewise',
            pieces: [
                { min: 1000, max: 1000000, label: '大于等于1000人', color: '#372a28' },
                { min: 500, max: 999, label: '500-999人', color: '#4e160f' },
                { min: 100, max: 499, label: '100-499人', color: '#974236' },
                { min: 10, max: 99, label: '10-99人', color: '#ee7263' },
                { min: 1, max: 9, label: '1-9人', color: '#f5bba7' },
            ],
            color: ['#E0022B', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        roamController: {
            show: true,
            left: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [
            {
                name: '人数',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    show: true,
                    color: 'rgb(249, 249, 249)'
                },
                data: []
            }
        ]
    };

    //使用指定的配置项和数据显示图表
    myChart.setOption(option);

    //获取数据
    function getData() {
        $.ajax({
            url: "/countByProvinceAndStu_grade",
            dataType: "json",
            success: function (data) {
                //  console.log(data.data)

                var newArr = [];
                //newArr的数据格式为：
                // [{
                //   name: '北京11',
                //   value: 212
                // }, {
                //   name: '天津',
                //   value: 60
                // }]

                //获取到各个省份的数据
                //  var province = res.areaTree[0].children;
                for (var i = 0; i < data.length; i++) {
                    if(data[i].stu_grade==2017){
                        var json = {
                            name: data[i].province,
                            value: data[i].quality
                        }
                        newArr.push(json)}
                }
                console.log(newArr)
                console.log(JSON.stringify(newArr))
                //使用指定的配置项和数据显示图表
                myChart.setOption({
                    series: [
                        {
                            name: '人数',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                show: true,
                                color: 'rgb(249, 249, 249)'
                            },
                            data: newArr
                        }
                    ]
                });

            }

        })
    }
    getData();
})
//2018级生源省图谱
$(function () {
    var myChart = echarts.init(document.getElementById('ProvinceAtlasEcharts_2018'));
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '2018级省份生源图',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['2018级省份生源图']
        },
        visualMap: {
            type: 'piecewise',
            pieces: [
                { min: 1000, max: 1000000, label: '大于等于1000人', color: '#372a28' },
                { min: 500, max: 999, label: '500-999人', color: '#4e160f' },
                { min: 100, max: 499, label: '100-499人', color: '#974236' },
                { min: 10, max: 99, label: '10-99人', color: '#ee7263' },
                { min: 1, max: 9, label: '1-9人', color: '#f5bba7' },
            ],
            color: ['#E0022B', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        roamController: {
            show: true,
            left: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [
            {
                name: '人数',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    show: true,
                    color: 'rgb(249, 249, 249)'
                },
                data: []
            }
        ]
    };

    //使用指定的配置项和数据显示图表
    myChart.setOption(option);

    //获取数据
    function getData() {
        $.ajax({
            url: "/countByProvinceAndStu_grade",
            dataType: "json",
            success: function (data) {
                //  console.log(data.data)

                var newArr = [];
                //newArr的数据格式为：
                // [{
                //   name: '北京11',
                //   value: 212
                // }, {
                //   name: '天津',
                //   value: 60
                // }]

                //获取到各个省份的数据
                //  var province = res.areaTree[0].children;
                for (var i = 0; i < data.length; i++) {
                    if(data[i].stu_grade==2018){
                        var json = {
                            name: data[i].province,
                            value: data[i].quality
                        }
                        newArr.push(json)}
                }
                console.log(newArr)
                console.log(JSON.stringify(newArr))
                //使用指定的配置项和数据显示图表
                myChart.setOption({
                    series: [
                        {
                            name: '人数',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                show: true,
                                color: 'rgb(249, 249, 249)'
                            },
                            data: newArr
                        }
                    ]
                });

            }

        })
    }
    getData();
})
//2019级生源省图谱
$(function () {
    var myChart = echarts.init(document.getElementById('ProvinceAtlasEcharts_2016'));
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '2019级省份生源图',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['2019级省份生源图']
        },
        visualMap: {
            type: 'piecewise',
            pieces: [
                { min: 1000, max: 1000000, label: '大于等于1000人', color: '#372a28' },
                { min: 500, max: 999, label: '500-999人', color: '#4e160f' },
                { min: 100, max: 499, label: '100-499人', color: '#974236' },
                { min: 10, max: 99, label: '10-99人', color: '#ee7263' },
                { min: 1, max: 9, label: '1-9人', color: '#f5bba7' },
            ],
            color: ['#E0022B', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        roamController: {
            show: true,
            left: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [
            {
                name: '人数',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    show: true,
                    color: 'rgb(249, 249, 249)'
                },
                data: []
            }
        ]
    };

    //使用指定的配置项和数据显示图表
    myChart.setOption(option);

    //获取数据
    function getData() {
        $.ajax({
            url: "/countByProvinceAndStu_grade",
            dataType: "json",
            success: function (data) {
                //  console.log(data.data)

                var newArr = [];
                //newArr的数据格式为：
                // [{
                //   name: '北京11',
                //   value: 212
                // }, {
                //   name: '天津',
                //   value: 60
                // }]

                //获取到各个省份的数据
                //  var province = res.areaTree[0].children;
                for (var i = 0; i < data.length; i++) {
                    if(data[i].stu_grade==2019){
                        var json = {
                            name: data[i].province,
                            value: data[i].quality
                        }
                        newArr.push(json)}
                }
                console.log(newArr)
                console.log(JSON.stringify(newArr))
                //使用指定的配置项和数据显示图表
                myChart.setOption({
                    series: [
                        {
                            name: '人数',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                show: true,
                                color: 'rgb(249, 249, 249)'
                            },
                            data: newArr
                        }
                    ]
                });

            }

        })
    }
    getData();
})

$(function(){


})