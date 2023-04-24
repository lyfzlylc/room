import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import axios from 'axios'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createPinia } from 'pinia'
// import APlayer from '@moefe/vue-aplayer';
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const pinia = createPinia()
const app = createApp(App)

//  引入所有图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
// 音乐盒
// app.use(APlayer, {
//     defaultCover: 'https://github.com/u3u.png',
//     productionTip: true,
// });
// axios
// app.config.globalProperties.$axios = axios
// 国际化
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
app.use(ElementPlus, {
    locale: zhCn,
})
app.use(router).use(ElementPlus).use(pinia).mount('#app')
