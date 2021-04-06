import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

public class GitHubCommands {

  public static void main(String[] args){
    String repoPath = "/Users/henokk_14/Downloads/CSC 109/Git-Educated-Challenge-2";
    GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
    String status = gitSubprocessClient.gitStatus();
    //String gitAddFile = gitSubprocessClient.gitAddFile("GitHubCommands.java");
    String gitAddAll = gitSubprocessClient.gitAddAll();
    String commitMessage = "added some of the functions";
    String commit = gitSubprocessClient.gitCommit(commitMessage);
    String push = gitSubprocessClient.gitPush("main");
    System.out.println(status);
    //System.out.println(gitAddFile);
    System.out.println(gitAddAll);
    System.out.println(commit);
    System.out.println(push);
  }
}
