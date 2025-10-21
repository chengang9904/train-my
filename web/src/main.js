import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
// 引入所有图标
import * as Icons from "@ant-design/icons-vue";

const app = createApp(App);

// 添加到全局（可加可不加）
app.use(Antd).use(router).use(store).mount('#app')
const icons = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}
