const { defineConfig } = require('@vue/cli-service')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  //  ui 组件
  configureWebpack: {
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()],
      }),
      Components({
        resolvers: [ElementPlusResolver()],
      }),
    ],
  },
  //跨域
  devServer: {
     open: true,
     port: '8080',
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        // target: 'http://192.168.1.10:8080',
        pathRewrite: { '^/api': '' }
      }
    },

    historyApiFallback: true,
    allowedHosts: "all"
  }
})
