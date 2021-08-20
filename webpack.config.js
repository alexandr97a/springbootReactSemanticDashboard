var path = require('path');
const imageInlineSizeLimit = parseInt(process.env.IMAGE_INLINE_SIZE_LIMIT || "2000");
module.exports = {
    context: path.resolve(__dirname, 'src/main/jsx'),
    entry: {
        main: './Main.jsx',
        add_table: './Add_table.jsx',
        table: './Table.jsx',
        edit_table: './Edit_table.jsx',
        login: './Login.jsx',
        signup: './Signup.jsx',
    },
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/webapp/js/react/[name].bundle.js'
    },
    mode: 'none',
    module: {
        rules: [ {
            test: /\.jsx?$/,
            exclude: /(node_modules)/,
            use: {
                loader: 'babel-loader',
                options: {
                    presets: [ '@babel/preset-env', '@babel/preset-react' ]
                }
            }
        }, {
            test: /\.css$/,
            use: [ 'style-loader', 'css-loader' ]
        },  {
            test: /\.(woff(2)?|ttf|eot|otf|svg)(\?v=\d+\.\d+\.\d+)?$/,
            use: [
              {
                loader: "file-loader",
                options: {
                  /*                    publicPath: './resources/font/'*/
                  name: "[name].[hash:8].[ext]",
                  outputPath: "resources/font/",
                },
              },
            ],
          },
          {
            test: [/\.bmp$/, /\.gif$/, /\.jpe?g$/, /\.png$/],
            use: [
              {
                loader: require.resolve("url-loader"),
                options: {
                  limit: imageInlineSizeLimit,
                  name: "/resources/images/[name].[hash:8].[ext]",
                },
              },
            ],
          }]
    }
};