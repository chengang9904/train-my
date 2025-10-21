import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
// 引入所有图标
import * as Icons from "@ant-design/icons-vue";
import axios from "axios";

const app = createApp(App);

// 添加到全局（可加可不加）
app.use(Antd).use(router).use(store).mount('#app')
const icons = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
    console.log('请求参数：', config);
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    console.log('返回结果：', response);
    return response;
}, error => {
    console.log('返回错误：', error);
    return Promise.reject(error);
});

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
console.log('环境：', process.env.VUE_APP_SERVER);
