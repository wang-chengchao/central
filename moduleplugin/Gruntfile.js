
const vendorLibs = ['bootstrap', 'jquery', 'angular', 'angular-route', 'admin-lte', 'rxjs', 'lodash', 'jstree', 'bootstrap-datepicker', 'flatpickr', 'mOxie'];

module.exports = function (grunt) {
    require('load-grunt-tasks')(grunt);

    grunt.initConfig({
        browserify: {
            main: {
                files: {
                    'src/main/resources/plugin-webapp/sample-plugin/app/dist/bundle.js': [
                        'src/main/resources/plugin-webapp/sample-plugin/app/plugin.js',
                      'src/main/resources/plugin-webapp/sample-plugin/app/plugin1.js'
                    ]
                },
                options: {
                    transform: ['brfs', ["babelify", { presets: ["@babel/preset-env"] }]],
                    external: vendorLibs
                }
            }
        }
    })

    grunt.registerTask('default', ['browserify']);
}