$(function() {
    let ctx = $("#regional_status");
    let regionalChart = new Chart(ctx, {
        type:'bar',
        options:{
            responsive:false
        },
        data:{
            labels:['서울', '경기', '대구', '인천', '부산', '경남', '경북', '충남',
            '강원', '대전', '충북', '광주', '울산', '전북', '전남', '제주', '세종'],
            datasets:[{
                label:"2021-08-09",
                data:[415, 86, 123],
                backgroundColor:['rgba(216, 178, 218, 0.733)']
            }]
        }
    });

    let ctx2 = $("#confirmed_chart");
    let confirmed_chart = new Chart(ctx2, {
        type:"pie",
        options:{
            responsive:false
        },
        data:{
            labels:["확진", "음성"],
            datasets:[
                {
                    label:"확진/음성",
                    data:[100, 200],
                    backgroundColor:['rgba(300, 178, 218, 0.733)', 'rgba(150, 178, 218, 0.733)']
                },
            ]
        }
    });

    let ctx3 = $("#vaccine_chart");
    let vaccineChart = new Chart(ctx3, {
        type:'bar',
        options:{
            responsive:false
        },
        data:{
            labels:['서울', '경기', '대구', '인천', '부산', '경남', '경북', '충남',
            '강원', '대전', '충북', '광주', '울산', '전북', '전남', '제주', '세종'],
            datasets:[{
                label:"2021-08-09 1차 접종",
                data:[415, 86, 123],
                backgroundColor:['rgba(100, 178, 218, 0.733)']
            },
            {
                label:"2021-08-09 2차 접종",
                data:[415, 86, 123],
                backgroundColor:['rgba(30, 178, 218, 0.733)']
            }
        ]
        }
    });
})