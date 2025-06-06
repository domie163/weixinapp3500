const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm20vfg/",
            name: "ssm20vfg",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm20vfg/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "松江大学城就餐推荐系统设计与实现"
        } 
    }
}
export default base
