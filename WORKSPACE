workspace(name = "nav")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

# Load rules scala annex
rules_scala_annex_commit = "0f3fd2734fe1930ed1ca0a3c1876af8f24e94be2"

rules_scala_annex_sha256 = "4b68b573162e38ec5ca792dfd7c326891e9a28e48afdb30d4bb90d0cba7216ab"

http_archive(
    name = "rules_scala_annex",
    sha256 = rules_scala_annex_sha256,
    strip_prefix = "rules_scala-{}".format(rules_scala_annex_commit),
    url = "https://github.com/higherkindness/rules_scala/archive/{}.zip".format(rules_scala_annex_commit),
)

rules_jvm_external_tag = "2.10"

rules_jvm_external_sha = "1bbf2e48d07686707dd85357e9a94da775e1dbd7c464272b3664283c9c716d26"

http_archive(
    name = "rules_jvm_external",
    sha256 = rules_jvm_external_sha,
    strip_prefix = "rules_jvm_external-%s" % rules_jvm_external_tag,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % rules_jvm_external_tag,
)

load("@rules_scala_annex//rules/scala:workspace.bzl", "scala_register_toolchains", "scala_repositories")

scala_repositories()

load("@annex//:defs.bzl", annex_pinned_maven_install = "pinned_maven_install")

annex_pinned_maven_install()

scala_register_toolchains()

load("@rules_scala_annex//rules/scalafmt:workspace.bzl", "scalafmt_default_config", "scalafmt_repositories")

scalafmt_repositories()

load("@annex_scalafmt//:defs.bzl", annex_scalafmt_pinned_maven_install = "pinned_maven_install")

annex_scalafmt_pinned_maven_install()

scalafmt_default_config()

load("@rules_scala_annex//rules/scala_proto:workspace.bzl", "scala_proto_register_toolchains", "scala_proto_repositories")

scala_proto_repositories()

load("@annex_proto//:defs.bzl", annex_proto_pinned_maven_install = "pinned_maven_install")

annex_proto_pinned_maven_install()

scala_proto_register_toolchains()

# Load bazel skylib and google protobuf
git_repository(
    name = "bazel_skylib",
    remote = "https://github.com/bazelbuild/bazel-skylib.git",
    tag = "0.8.0",
)

http_archive(
    name = "com_google_protobuf",
    sha256 = "0963c6ae20340ce41f225a99cacbcba8422cebe4f82937f3d9fa3f5dd7ae7342",
    strip_prefix = "protobuf-9f604ac5043e9ab127b99420e957504f2149adbe",
    urls = ["https://github.com/google/protobuf/archive/9f604ac5043e9ab127b99420e957504f2149adbe.zip"],
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven_scala_2.12",
    artifacts = [
        "org.scala-lang:scala-library:2.12.10",
        "org.scala-lang:scala-reflect:2.12.10",
        "org.scala-lang:scala-compiler:2.12.10",
        "org.scala-sbt:zinc_2.12:1.2.1",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-databind:2.9.10",
        "com.fasterxml.jackson.module:jackson-module-scala_2.12:2.9.10",
        "org.scalatest:scalatest_2.12:3.0.8",
    ],
    fetch_sources = True,
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

# Specify the scala compiler we wish to use; in this case, we'll use the default one specified in rules_scala_annex
bind(
    name = "default_scala",
    actual = "//:default_scala",
)
