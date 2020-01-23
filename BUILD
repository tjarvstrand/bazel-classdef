load(
    "@rules_scala_annex//rules:scala.bzl",
    "configure_bootstrap_scala",
    "configure_zinc_scala",
    "scala_library",
)

compiler_classpath = [
     "@maven_scala_2.12//:org_scala_lang_scala_compiler",
     "@maven_scala_2.12//:org_scala_lang_scala_library",
     "@maven_scala_2.12//:org_scala_lang_scala_reflect",
]

runtime_classpath = [
    "@maven_scala_2.12//:org_scala_lang_scala_library",
]

configure_bootstrap_scala(
    name = "bootstrap",
    compiler_classpath = compiler_classpath,
    runtime_classpath = runtime_classpath,
    version = "2.12.10",
    visibility = ["//visibility:public"],
)

scala_library(
    name = "compiler_bridge",
    srcs = [
        "@compiler_bridge_2_12//:src",
    ],
    scala = ":bootstrap",
    visibility = ["//visibility:public"],
    deps = compiler_classpath + [
        "@maven_scala_2.12//:org_scala_sbt_compiler_interface",
        "@maven_scala_2.12//:org_scala_sbt_util_interface",
    ],
)

configure_zinc_scala(
    name = "zinc",
    compiler_bridge = ":compiler_bridge",
    compiler_classpath = compiler_classpath,
    runtime_classpath = runtime_classpath,
    version = "2.12.10",
    visibility = ["//visibility:public"],
)

alias(
    name = "default_scala",
    actual = ":zinc",
    visibility = ["//visibility:public"],
)

