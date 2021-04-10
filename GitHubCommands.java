import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

public class GitHubCommands {
  GitSubprocessClient gitSubprocessClient;
  String filename = "Hello";
  public GitHubCommands(){
    String repoPath = "/Users/henokk_14/Downloads/CSC 109/Git-Educated-Challenge-2";
    GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
    String status = gitSubprocessClient.gitStatus();
    this.GitAdd( gitSubprocessClient,"GitHubCommands.java");
    // String gitAddFile = gitSubprocessClient.gitAddFile("GitHubCommands.java");
    //String gitAddAll = gitSubprocessClient.gitAddAll();
    String commitMessage = "added-some-of-the-functions";
    String commit = gitSubprocessClient.gitCommit(commitMessage);
    String push = gitSubprocessClient.gitPush("main");
    System.out.println(status);
  }
  public static void main(String[] args){
     GitHubCommands run =  new GitHubCommands();
  }

  public void GitAdd(GitSubprocessClient gitSubprocessClient,String filename) {
    try {
      String gitAddFile = gitSubprocessClient.gitAddFile(filename);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error file name entered incorrect file:"+ filename+ " Doesn't exist in scope" );
    }
  }

}
